package hoHoangVanAnh.bai07;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SoftwareHouse {
	private String theName;
	private List<Employee> list;
	
	/**
	 * hàm khởi tạo
	 * @param theName
	 */
	public SoftwareHouse(String theName) {
		this.theName = theName;
		list = new ArrayList<Employee>();
	}
	/**
	 * thêm vào 1 Employee trùng mã thêm không đc
	 * @param emp
	 * @return
	 */
	public boolean ThemEmp(Employee emp) {
		if(list.contains(emp))
			return false;
		list.add(emp);
		return true;
	}
	
	public String displayAllStaff() {
		String s = Employee.getTieuDe() + "\n";
		for (Employee empLoyee : list) {
			s += empLoyee + "\n";
		}
		return s;
	}
	/**
	 * tính tổng tiền phải trả cho các nhân viên.
	 * @return
	 */
	public double getMonthlySalaryBill() {
		double sum = 0;
		for (Employee empLoyee : list) {
			sum += empLoyee.getMonthlySalary();
		}
		return sum;
	}
	/**
	 * , sắp xếp danh sách nhân viên theo tên.
	 */
	public void xapdanhsachtheoten() {
		Collections.sort(list, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.theName.compareToIgnoreCase(o2.theName);
			}
		});
	}
	
	/**
	 * in thông tin lập trình viên
	 */
	public String getThongTinLapTrinhVien() {
		String s = Programmer.getTieuDe() + "\n";
		for (Employee empLoyee : list) {
			if(empLoyee instanceof Programmer) {
				s += empLoyee + "\n";
			}
		}
		return s;
	}
	/**
	 * cập nhật phòng ban là deptNew cho người quản lý có mã số là aPayrollNo, 
	 * trả về true nếu cập nhật thành công
	 * @param aPayrollNo
	 * @param deptNew
	 * @return
	 */
	public boolean updateDepartmentForAdmin(int aPayrollNo, String deptNew) {
		for (Employee empLoyee : list) {
			if(empLoyee.getThePayrollNumber() == aPayrollNo)
				if(empLoyee instanceof Administrator)
					((Administrator) empLoyee).setTheDepartment(deptNew);
					return true;
		}
		return false;
	}
	/**
	 * xóa nhân viên theo mã số, trả về true nếu xóa được.
	 * @param id
	 * @return
	 */
	public boolean deleteEmployee(int id) {
		return list.removeIf(emp -> emp.getThePayrollNumber() == id);
	}
	
	
	
}

