package gapp.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import gapp.model.AdditionalInfo;
import gapp.model.Department;
import gapp.model.DepartmentMajor;
import gapp.model.DepartmentObjectList;
import gapp.model.User;
import gapp.model.dao.AdditionalInfoDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.DepartmentMajorDao;

@Controller
public class DepartmentController {
	
	@Autowired
    DepartmentDao departmentDao;
	
	@Autowired
    DepartmentMajorDao departmentmajorDao;
	
	@Autowired
    AdditionalInfoDao infoDao;
	

	@RequestMapping(value = "/department/departmentlists.html", method = RequestMethod.GET)
	    public String login( HttpServletRequest request, ModelMap models )
	    {														
	  
		 List<Department> d = departmentDao.getDepartments();
		 models.put("dept",d);
		 
		 List<DepartmentObjectList> list = new ArrayList<DepartmentObjectList>();
		 List<Object[]> obj = departmentmajorDao.getNumberMajor();
		 
		 for(Object[] each:obj)
		 {
			list.add(new DepartmentObjectList(Integer.parseInt(each[1].toString()), Integer.parseInt(each[0].toString()))); 
		 }
		 
		 models.put("major",list );
	
		 
	        return "department/departmentlists";
	    }

	 @RequestMapping(value = "/department/viewdepartment.html", method = RequestMethod.GET)
	    public String view( @RequestParam Integer id, ModelMap models )
	    {														
	        models.put("dept", departmentDao.getDepartment(id));
	        models.put("program",departmentmajorDao.getMajor(departmentDao.getDepartment(id).getId()));
	        models.put("info",infoDao.getInfo(departmentDao.getDepartment(id).getId()));
	        return "department/viewdepartment";
	    }	 
	 
	 @RequestMapping(value = "/department/addDepartment.html", method = RequestMethod.GET)
	    public String add( ModelMap models )
	    {														
		 models.addAttribute("department", new Department()); 
	        return "department/addDepartment";
	    }	 

	 @RequestMapping(value = "/department/addDepartment.html", method = RequestMethod.POST)
	    public String add( @ModelAttribute Department department )
	    {				
		 department.setValid(true);
		 departmentDao.saveDepartment(department);
		 return "redirect:/department/departmentlists.html";
	    }	 
	 
	 @RequestMapping(value = "/department/addProgram.html", method = RequestMethod.GET)
	    public String addProgram( ModelMap models,@ModelAttribute Department department )
	    {				
		 
		 models.addAttribute("program", new DepartmentMajor());
		 models.put("dept",departmentDao.getDepartments() );
		 return "department/addProgram";
	    }	 
	 
	 @RequestMapping(value = "/department/addProgram.html", method = RequestMethod.POST)
	    public String addProgram(  @ModelAttribute DepartmentMajor departmentMajor,@RequestParam String dept )
	    {					
		 departmentMajor.setDepartment(departmentDao.getDepartment(Integer.parseInt(dept)));
		 departmentMajor.setValid(true);
		 departmentmajorDao.saveDepartmentMajor(departmentMajor);
		 return "redirect:/department/departmentlists.html";
	    }	
	 
	 
	 @RequestMapping(value = "/department/addAdditionalinfo.html", method = RequestMethod.GET)
	    public String addInfo( ModelMap models )
	    {					
		 models.addAttribute("additionalinfo", new AdditionalInfo());
		 models.put("dept",departmentDao.getDepartments() );
		 return "department/addAdditionalinfo";
	    }	 
	 
	 @RequestMapping(value = "/department/addAdditionalinfo.html", method = RequestMethod.POST)
	    public String addInfo( ModelMap models,@ModelAttribute AdditionalInfo info,@RequestParam String type ,@RequestParam String req,@RequestParam String dept)
	    {				
		 info.setValid(true);
		 info.setDepartment(departmentDao.getDepartment(Integer.parseInt(dept)));
		 info.setType(type);
		info.setRequired(Boolean.parseBoolean(req));
		 infoDao.saveInfo(info);
		 return "redirect:/department/departmentlists.html";
	    }	 
	 
	 @RequestMapping(value = "/department/editdepartment.html", method = RequestMethod.GET)
	    public String editdept( ModelMap models,@RequestParam Integer id )
	    {					
		 models.addAttribute("department", new Department());
		 models.put("dept",departmentDao.getDepartment(id) );
		 return "department/editdepartment";
	    }	 
	 
	 @RequestMapping(value = "/department/editdepartment.html", method = RequestMethod.POST)
	    public String editdept( @ModelAttribute Department department,SessionStatus sessionStatus )
	    {			
		 department.setValid(true);
		 departmentDao.saveDepartment(department);
	        sessionStatus.setComplete();
		 return "redirect:/department/departmentlists.html";
	    }	 
	 
	 @RequestMapping(value = "/department/removeprogram.html", method = RequestMethod.GET)
	    public String removeprogram( @RequestParam Integer id, ModelMap models )
	    {					
		    models.put("dept", departmentDao.getDepartment(id));
	        models.put("program",departmentmajorDao.getMajor(id));
	        return "department/removeprogram";
	    }	 
	 
	 @RequestMapping(value = "/department/remprog.html", method = RequestMethod.GET)
	    public String remprog( @RequestParam Integer id )
	    {				
		 	DepartmentMajor d = departmentmajorDao.getMajorByDept(id);
	        departmentmajorDao.removeMajor(id);
	        return "redirect:/department/removeprogram.html?id="+d.getDepartment().getId();
	    }	 
	 
	 @RequestMapping(value = "/department/removeadditional.html", method = RequestMethod.GET)
	    public String removeadditional( @RequestParam Integer id, ModelMap models )
	    {														
	        models.put("dept", departmentDao.getDepartment(id));
	        models.put("info",infoDao.getInfo(id));
	        return "department/removeadditional";
	    }	
	 
	 @RequestMapping(value = "/department/reminfo.html", method = RequestMethod.GET)
	    public String reminfo( @RequestParam Integer id )
	    {			
		 	AdditionalInfo a   = infoDao.getInfoByDept(id);
	        infoDao.removeInfo(id);
	        return "redirect:/department/removeadditional.html?id="+a.getDepartment().getId();
	    }	 
	 
}
