package gapp.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gapp.model.AdditionRecord;
import gapp.model.AdditionalInfo;
import gapp.model.Application;
import gapp.model.Department;
import gapp.model.DepartmentMajor;
import gapp.model.EducationInfo;
import gapp.model.Student;
import gapp.model.User;
import gapp.model.dao.AdditionRecordDao;
import gapp.model.dao.AdditionalInfoDao;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.ApplicationStatusDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.DepartmentMajorDao;
import gapp.model.dao.EducationInfoDao;
import gapp.model.dao.StudentDao;
import gapp.model.dao.UserDao;

@Controller
public class ApplicationController {

	@Autowired
	private ServletContext context;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ApplicationStatusDao statusDao;

	@Autowired
	private EducationInfoDao infoDao;
	@Autowired
	StudentDao studentDao;

	@Autowired
	private DepartmentMajorDao departmentmajorDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private EducationInfoDao eduDao;

	@Autowired
	private AdditionalInfoDao additionalInfoDao;

	@Autowired
	private AdditionRecordDao additionalDao;

	@Autowired
	private ApplicationDao appDao;

	private static final ObjectMapper object = new ObjectMapper();

	@RequestMapping(value = "/application/apply.html", method = RequestMethod.GET)
	public String apply(HttpServletRequest request, ModelMap models, HttpSession session) {
		String id = session.getAttribute("uid").toString();
		models.put("user", userDao.getUser(Integer.parseInt(id)));
		// models.addAttribute("application", new Application());
		models.put("dept", departmentDao.getDepartments());
		return "application/apply";
	}

	@RequestMapping(value = "/application/editapplication.html", method = RequestMethod.GET)
	public String edit(@RequestParam Integer id, ModelMap models, HttpSession session) {
		String id1 = session.getAttribute("uid").toString();
		models.put("user", userDao.getUser(Integer.parseInt(id1)));
		models.put("app", appDao.getApplicationsById(id));
		Date a = appDao.getApplicationsById(id).getStudent().getDOB();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String s = formatter.format(a);
		models.put("s", s);
		List<AdditionRecord> records = (List<AdditionRecord>) additionalDao.getrecord(id);
		models.put("records", records);
		models.put("major",
				departmentmajorDao.getMajor(appDao.getApplicationsById(id).getProgram().getDepartment().getId()));
		models.put("info", eduDao.getEducationInfoByApplicationid(id));

		return "application/editapplication";
	}

	@RequestMapping(value = "/application/editapplication.html", method = RequestMethod.POST)
	public String edit(ModelMap models, HttpServletRequest request, @RequestParam MultipartFile file,
			HttpSession session, @RequestParam String program, @RequestParam String action,
			@RequestParam("req") MultipartFile[] req) {
		int app_id = Integer.parseInt(request.getParameter("app_id"));
		String file_name = request.getParameter("file_name");
		int count = 0;

		String id = session.getAttribute("uid").toString();

		Student s = appDao.getApplicationsById(app_id).getStudent();

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String fn = request.getParameter("fn");
		String ln = request.getParameter("ln");
		String cin = request.getParameter("cin");
		String pn = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		boolean in = Boolean.parseBoolean(request.getParameter("international"));
		Date date = null;
		try {
			date = formatter.parse(dob);
		} catch (ParseException e) {

		}
		String citizen = request.getParameter("citizen");
		s.setFirstName(fn);
		s.setLastName(ln);
		if (request.getParameter("cin") != null && !request.getParameter("cin").trim().isEmpty()) {
			s.setCIN(cin);
		} else {
			s.setCIN("");
		}
		s.setCitizenship(citizen);
		s.setInternational(in);
		s.setDOB(date);
		s.setEmail(email);
		s.setPhone(pn);
		s.setGender(gender);
		s.setValid(true);
		s.setUser(userDao.getUser(Integer.parseInt(id)));
		Student stu = studentDao.saveStudent(s);

		Application application = appDao.getApplicationsById(app_id);
		application.setGPA(Double.parseDouble(request.getParameter("GPA")));
		application.setTerm(request.getParameter("term"));
		if (request.getParameter("TOEFL") != null && !request.getParameter("TOEFL").trim().isEmpty()) {
			application.setTOEFL(Integer.parseInt(request.getParameter("TOEFL")));
		} else {
			application.setTOEFL(null);
		}
		application.setProgram(departmentmajorDao.getDepartmentMajor(Integer.parseInt(program)));
		application.setStudent(stu);
		application.setStatus(statusDao.getStatus(1));
		application.setValid(true);

		if (action.equals("Submit")) {
			application.setSubmited(true);
			application.setCreatedOn(new Date());
		} else {
			application.setSubmited(false);
		}

		if (file.getOriginalFilename() != null && !file.getOriginalFilename().trim().isEmpty()) {
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-S");
			String[] resultfile = file.getOriginalFilename().split("[.]");
			String filename = resultfile[0] + formatter1.format(new Date()) + "." + resultfile[1];

			application.setTranscript(filename);

			try {
				file.transferTo(new File(getFileDirectory(), filename));
			} catch (IllegalStateException e) {

			} catch (IOException e) {

			}
		} else {
			application.setTranscript(file_name);
		}
		Application a = appDao.saveApplication(application);

		if (request.getParameter("clg") != null && !request.getParameter("clg").trim().isEmpty()) {
			String clg = request.getParameter("clg");
			String duration = request.getParameter("duration");
			String degree = request.getParameter("degree");
			String major = request.getParameter("major");
			EducationInfo info = new EducationInfo();
			info.setApplication(a);
			info.setCollegeName(clg);
			info.setDegreeEarned(degree);
			info.setDuration(duration);
			info.setMajor(major);
			info.setStudent(stu);
			info.setValid(true);

			infoDao.saveInfo(info);
		}
		if (request.getParameter("clg1") != null && !request.getParameter("clg1").trim().isEmpty()) {
			String clg1 = request.getParameter("clg1");
			String duration1 = request.getParameter("duration1");
			String degree1 = request.getParameter("degree1");
			String major1 = request.getParameter("major1");
			EducationInfo info1 = new EducationInfo();
			info1.setApplication(a);
			info1.setCollegeName(clg1);
			info1.setDegreeEarned(degree1);
			info1.setDuration(duration1);
			info1.setMajor(major1);
			info1.setStudent(stu);
			info1.setValid(true);
			infoDao.saveInfo(info1);
		}

		if (request.getParameter("clg2") != null && !request.getParameter("clg2").trim().isEmpty()) {
			String clg2 = request.getParameter("clg2");
			String duration2 = request.getParameter("duration2");
			String degree2 = request.getParameter("degree2");
			String major2 = request.getParameter("major2");
			EducationInfo info2 = new EducationInfo();
			info2.setApplication(a);
			info2.setCollegeName(clg2);
			info2.setDegreeEarned(degree2);
			info2.setDuration(duration2);
			info2.setMajor(major2);
			info2.setStudent(stu);
			info2.setValid(true);
			infoDao.saveInfo(info2);
		}

		List<AdditionalInfo> d = (List<AdditionalInfo>) additionalInfoDao
				.getInfo(a.getProgram().getDepartment().getId());

		for (AdditionalInfo each : d) {

			if (each.getType().equals("Text") || each.getType().equals("Number")) {
				if (request.getParameter(each.getName()) != null
						&& !request.getParameter(each.getName()).trim().isEmpty()) {
					AdditionRecord record = new AdditionRecord();
					record.setApplication(a);
					record.setStudent(stu);
					record.setValid(true);
					record.setInfo(each);
					record.setValue(request.getParameter(each.getName()));
					additionalDao.saveRecord(record);
				}
			} else {
				for (int i = 0; i < req.length; i++) {
					if (count == i) {

						String f = req[i].getName();
						if (req[i].getOriginalFilename() != null && !req[i].getOriginalFilename().trim().isEmpty()) {
							AdditionRecord record = new AdditionRecord();
							record.setApplication(a);
							record.setStudent(stu);
							record.setValid(true);
							record.setInfo(each);
							SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-S");
							if (req[i].getOriginalFilename() != null
									&& !req[i].getOriginalFilename().trim().isEmpty()) {
								String[] resultfile1 = req[i].getOriginalFilename().split("[.]");
								String fname = resultfile1[0] + formatter1.format(new Date()) + "." + resultfile1[1];
								record.setValue(fname);
								try {
									req[i].transferTo(new File(getFileDirectory(), fname));
								} catch (IllegalStateException e) {

								} catch (IOException e) {

								}
							} else {
								record.setValue("");
							}
							additionalDao.saveRecord(record);
						}
						
					}

				}
				count++;
			}

		}

		return "redirect:/user/homestudent.html";

	}

	@RequestMapping(value = "/application/viewapplication.html", method = RequestMethod.GET)
	public String view(@RequestParam Integer id, ModelMap models, HttpSession session) {
		String id1 = session.getAttribute("uid").toString();
		models.put("user", userDao.getUser(Integer.parseInt(id1)));
		models.put("app", appDao.getApplicationsById(id));
		models.put("info", eduDao.getEducationInfoByApplicationid(id));
		models.put("additional", additionalDao.getrecord(id));
		return "application/viewapplication";
	}

	@RequestMapping(value = "/application/inforemove.html", method = RequestMethod.GET)
	public String removeinfo(@RequestParam Integer id, @RequestParam Integer appid, ModelMap models) {
		EducationInfo e = eduDao.get(id);
		e.setValid(false);
		eduDao.saveInfo(e);
		return "redirect:editapplication.html?id=" + appid;
	}

	@RequestMapping(value = "/application/additionalremove.html", method = RequestMethod.GET)
	public String removadditional(@RequestParam Integer id, @RequestParam Integer appid, ModelMap models) {
		AdditionRecord e = additionalDao.getRecord(id);
		e.setValid(false);
		additionalDao.saveRecord(e);
		return "redirect:editapplication.html?id=" + appid;
	}

	@RequestMapping(value = "/application/getprogram.html", method = RequestMethod.POST)
	public @ResponseBody String getprogram(@RequestParam(value = "id") Integer id, ModelMap models,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {

		List<DepartmentMajor> d = (List<DepartmentMajor>) departmentmajorDao.getProgrambyAjax(id);

		response.setContentType("application/json");
		object.writeValue(response.getWriter(), d);
		return "application/getprogram";
	}

	@RequestMapping(value = "/application/getAdd.html", method = RequestMethod.POST)
	public @ResponseBody String getAdd(@RequestParam(value = "id") Integer id, ModelMap models,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {

		List<AdditionalInfo> d = (List<AdditionalInfo>) additionalInfoDao.getInfo(id);
		response.setContentType("application/json");
		object.writeValue(response.getWriter(), d);
		return "application/getAdd";
	}

	@RequestMapping(value = "/application/getValue.html", method = RequestMethod.POST)
	public @ResponseBody String getVal(@RequestParam(value = "id") Integer id, ModelMap models,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {

		List<AdditionRecord> records = (List<AdditionRecord>) additionalDao.getrecord(id);
		response.setContentType("application/json");
		object.writeValue(response.getWriter(), records);
		return null;
	}

	@RequestMapping(value = "/application/apply.html", method = RequestMethod.POST)
	public String apply(HttpServletRequest request, @RequestParam String program, @RequestParam String action,
			HttpSession session, @RequestParam MultipartFile file, @RequestParam("req") MultipartFile[] req) {
		String id = session.getAttribute("uid").toString();
		Student s = new Student();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String fn = request.getParameter("fn");
		String ln = request.getParameter("ln");
		String cin = request.getParameter("cin");
		String pn = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		boolean in = Boolean.parseBoolean(request.getParameter("international"));
		Date date = null;
		try {
			date = formatter.parse(dob);
		} catch (ParseException e) {

		}
		String citizen = request.getParameter("citizen");
		s.setFirstName(fn);
		s.setLastName(ln);
		if (request.getParameter("cin") != null && !request.getParameter("cin").trim().isEmpty()) {
			s.setCIN(cin);
		} else {
			s.setCIN("");
		}
		s.setCitizenship(citizen);
		s.setInternational(in);
		s.setDOB(date);
		s.setEmail(email);
		s.setPhone(pn);
		s.setGender(gender);
		s.setValid(true);
		s.setUser(userDao.getUser(Integer.parseInt(id)));
		Student stu = studentDao.saveStudent(s);

		Application application = new Application();
		application.setGPA(Double.parseDouble(request.getParameter("GPA")));
		application.setTerm(request.getParameter("term"));
		if (request.getParameter("TOEFL") != null && !request.getParameter("TOEFL").trim().isEmpty()) {
			application.setTOEFL(Integer.parseInt(request.getParameter("TOEFL")));
		} else {
			application.setTOEFL(null);
		}
		application.setProgram(departmentmajorDao.getDepartmentMajor(Integer.parseInt(program)));
		application.setStudent(stu);
		application.setStatus(statusDao.getStatus(1));
		application.setValid(true);

		if (action.equals("Submit")) {
			application.setSubmited(true);
			application.setCreatedOn(new Date());
		} else {
			application.setSubmited(false);
		}

		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-S");
		String[] resultfile = file.getOriginalFilename().split("[.]");
		String filename = resultfile[0] + formatter1.format(new Date()) + "." + resultfile[1];

		application.setTranscript(filename);
		try {
			file.transferTo(new File(getFileDirectory(), filename));
		} catch (IllegalStateException e) {

		} catch (IOException e) {

		}
		Application a = appDao.saveApplication(application);

		String clg = request.getParameter("clg");
		String duration = request.getParameter("duration");
		String degree = request.getParameter("degree");
		String major = request.getParameter("major");
		EducationInfo info = new EducationInfo();
		info.setApplication(a);
		info.setCollegeName(clg);
		info.setDegreeEarned(degree);
		info.setDuration(duration);
		info.setMajor(major);
		info.setStudent(stu);
		info.setValid(true);

		infoDao.saveInfo(info);

		if (request.getParameter("clg1") != null && !request.getParameter("clg1").trim().isEmpty()) {
			String clg1 = request.getParameter("clg1");
			String duration1 = request.getParameter("duration1");
			String degree1 = request.getParameter("degree1");
			String major1 = request.getParameter("major1");
			EducationInfo info1 = new EducationInfo();
			info1.setApplication(a);
			info1.setCollegeName(clg1);
			info1.setDegreeEarned(degree1);
			info1.setDuration(duration1);
			info1.setMajor(major1);
			info1.setStudent(stu);
			info1.setValid(true);
			infoDao.saveInfo(info1);
		}

		if (request.getParameter("clg2") != null && !request.getParameter("clg2").trim().isEmpty()) {
			String clg2 = request.getParameter("clg2");
			String duration2 = request.getParameter("duration2");
			String degree2 = request.getParameter("degree2");
			String major2 = request.getParameter("major2");
			EducationInfo info2 = new EducationInfo();
			info2.setApplication(a);
			info2.setCollegeName(clg2);
			info2.setDegreeEarned(degree2);
			info2.setDuration(duration2);
			info2.setMajor(major2);
			info2.setStudent(stu);
			info2.setValid(true);
			infoDao.saveInfo(info2);
		}

		int count = 0;
		List<AdditionalInfo> d = (List<AdditionalInfo>) additionalInfoDao
				.getInfo(a.getProgram().getDepartment().getId());

		for (AdditionalInfo each : d) {

			if (each.getType().equals("Text") || each.getType().equals("Number")) {
				if (request.getParameter(each.getName()) != null
						&& !request.getParameter(each.getName()).trim().isEmpty()) {
					AdditionRecord record = new AdditionRecord();
					record.setApplication(a);
					record.setStudent(stu);
					record.setValid(true);
					record.setInfo(each);
					record.setValue(request.getParameter(each.getName()));
					additionalDao.saveRecord(record);
				}
			} else {
				for (int i = 0; i < req.length; i++) {
					if (count == i) {

						String f = req[i].getName();
						if (req[i].getOriginalFilename() != null && !req[i].getOriginalFilename().trim().isEmpty()) {
							AdditionRecord record = new AdditionRecord();
							record.setApplication(a);
							record.setStudent(stu);
							record.setValid(true);
							record.setInfo(each);

							if (req[i].getOriginalFilename() != null
									&& !req[i].getOriginalFilename().trim().isEmpty()) {
								String[] resultfile1 = req[i].getOriginalFilename().split("[.]");
								String fname = resultfile1[0] + formatter1.format(new Date()) + "." + resultfile1[1];
								record.setValue(fname);
								try {
									req[i].transferTo(new File(getFileDirectory(), fname));
								} catch (IllegalStateException e) {

								} catch (IOException e) {

								}
							} else {
								record.setValue("");
							}

							additionalDao.saveRecord(record);
						}
					}
					
				}
				count++;
			}
		}

		return "redirect:/user/homestudent.html";
	}

	@RequestMapping(value = "/application/download.html")
	public String download(HttpServletResponse response, @RequestParam String filename) throws IOException {
		File file = new File(filename);
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", "inline; filename=" + filename);

		FileInputStream in = new FileInputStream(new File(getFileDirectory(), filename));
		OutputStream out = response.getOutputStream();

		byte buffer[] = new byte[2048];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) > 0)
			out.write(buffer, 0, bytesRead);

		in.close();
		return null;
	}

	@RequestMapping(value = "/application/File.html", method = RequestMethod.GET)
	public String file() {

		return "application/File";
	}

	private File getFileDirectory() {
		String path = context.getRealPath("/WEB-INF/files");
		return new File(path);
	}

	@RequestMapping(value = "/application/File.html", method = RequestMethod.POST)
	public String file(@RequestParam MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(new File(getFileDirectory(), file.getOriginalFilename()));
		return "redirect:/application/viewapplication";
	}

}
