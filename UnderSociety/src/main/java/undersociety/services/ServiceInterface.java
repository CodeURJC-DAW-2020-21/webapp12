package undersociety.services;

import java.util.List;

public interface ServiceInterface {
	public List<?> load();
	public int save(Object p);
	public void delete(int id);
	public boolean existsById(int id);
	public Object findById(int id);
	public Object findByUser_name(String username);
	public boolean findByUser_nameExists(String username);
}
