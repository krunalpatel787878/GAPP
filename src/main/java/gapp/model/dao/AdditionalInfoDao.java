package gapp.model.dao;

import java.util.List;

import gapp.model.AdditionalInfo;
import gapp.model.User;

public interface AdditionalInfoDao {
	
	public List<AdditionalInfo> getInfo(int id);

	AdditionalInfo saveInfo( AdditionalInfo info );
	
	Integer removeInfo(int id);
	
	AdditionalInfo getInfoByDept(int id);
	
	List<AdditionalInfo> getInfoBtdepartment(int dept);
}
