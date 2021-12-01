-- Hồ Hoàng Vân Anh_20098521_Tuần 7
--Câu 1-- Danh sách các orders ứng với tổng tiền của từng hóa đơn. 
--Thông tin bao gồm OrdersId, OrderDate, TotalAccount. 
--Trong đó TotalAccount là Sum của Quantity * Unitprice, kết nhóm theo OrderId.
select o.OrderID, o.OrderDate,sum(UnitPrice*Quantity) as 'TotalAccount'
from [Order Details] od join Orders o on o.OrderID=od.OrderID
group by o.OrderID,o.OrderDate

select od.OrderID, OrderDate, Sum(Quantity*UnitPrice) as TotalAccount
from Orders o join [Order Details] od on o.OrderID = od.OrderID
group by od.OrderID, OrderDate
-- Hoặc --
select d.OrderID,o.OrderDate, sum( Quantity* Unitprice) as TotalAcount
from [Order Details] d inner join Orders o
on d.OrderID= o.OrderID
group by d.OrderID,o.OrderDate
--Câu 2-- Danh sách các orders ứng với tổng tiền của từng hóa đơn có Shipcity là ‘Madrid’.
--Thông tin bao gồm OrdersId, OrderDate, TotalAccount. 
--Trong đó TotalAccount là Sum của Quantity * Unitprice, kết nhóm theo OrderId.
select o.OrderID,o.OrderDate, SUM(od.Quantity*od.UnitPrice) as 'TotalAccount'
from [Order Details] od join Orders o on o.OrderID=od.OrderID
where o.ShipCity like ('%Madrid%')
group by o.OrderID,o.OrderDate
--Hoặc--
select o.OrderID, OrderDate,SUM(Quantity*UnitPrice) as 'TotalAccount'
from [Order Details] od join Orders o on o.OrderID=od.OrderID
where ShipCity='Madrid'
group by o.OrderID,OrderDate 

--Câu 3-- Danh sách các products có tổng số lượng lập hóa đơn lớn nhất.
select top 1 p.ProductID, p.ProductName, count(orderID) as SoLuongHD
from [Order Details] od join Products p 
on p.ProductID=od.ProductID
GROUP by p.ProductID, p.ProductName
order by SoLuongHD desc
--Hoặc--
select top 1 with ties p.ProductID, COUNT(OrderID) as SoHDlap
from Products p join [Order Details] o 
on p.ProductID=o.ProductID
group by p.ProductID
order by  SoHDlap desc

--Câu 4-- Cho biết mỗi customers đã lập bao nhiêu lượt hóa đơn bao. 
--Thông tin gồm CustomerID, CompanyName, CountOfOrder. 
--Trong đó CountOfOrder (tổng số hóa đơn) được đếm (Count) theo từng Customers.
select c.CustomerID,c.CompanyName,COUNT(*) as 'CountOfOrder'
from Orders o join Customers c on c.CustomerID = o.CustomerID
group by c.CustomerID,c.CompanyName
order by COUNT(*) 
--Hoặc--
select c.CustomerID,c.CompanyName,COUNT(*) as 'So_Lan_Lap'
from Orders o join Customers c on c.CustomerID = o.CustomerID
group by c.CustomerID,c.CompanyName
order by COUNT(*) 

--Câu 5-- Cho biết mỗi Employee đã lập được bao nhiêu hóa đơn, ứng với tổng tiền.
select o.EmployeeID, e.FirstName, count(o.OrderID) as SoLuongHD, sum (Quantity*UnitPrice) as TongTien
from Orders o join [Order Details] od on o.OrderID = od.OrderID 
join Employees e on o.EmployeeID = e.EmployeeID
group by o.EmployeeID, e.FirstName

/*--Câu 6-- Cho biết những Customers chưa từng lập hóa đơn.
---select * from Customers c inner join Orders o on o.CustomerID=c.CustomerID --830
select c.CustomerID,c.CompanyName,COUNT(*) as 'CountOfOrder'
from dbo.Orders o join dbo.Customers c on c.CustomerID = o.CustomerID
group by c.CustomerID,c.CompanyName
having COUNT(*)=0
--Hoặc--
select c.CustomerID, o.OrderID from Customers c left join Orders o on o.CustomerID=c.CustomerID
where  OrderID is null 
---select * from Customers c right join Orders o on o.CustomerID=c.CustomerID 
-------------
--select c.CustomerID,c.CompanyName,COUNT(*) as 'So_Hoa_Don'
--from Orders o join Customers c on c.CustomerID = o.CustomerID
--group by c.CustomerID,c.CompanyName
--having COUNT(*)=0

--Câu 7-- Danh sách các customer ứng với tổng tiền các hoá đơn được lập từ 31/12/1996 đến 1/1/1998.
select c.CustomerID, c.CompanyName, '$' + 
convert(char,sum(od.UnitPrice*od.Quantity)) as 'Tong_Tien'
from Customers c join Orders o on o.CustomerID=c.CustomerID 
join [Order Details] od on od.OrderID=o.OrderID
where o.OrderDate between '12/31/1996' and '1/1/1998'
group by  c.CustomerID, c.CompanyName
*/
-- Câu 6: Liệt kê bảng lương của mỗi nhân viên theo từng tháng trong năm 1996 gồm 
-- EmployeeID, EmployName, Month_Salary, Salary = 
-- sum(quantity*unitprice)*10%. Được sắp xếp theo Month_Salary, cùmg 
-- Month_Salary thì sắp xếp theo Salary giảm dần.
select e.EmployeeID, e.LastName, 
convert(char,sum(Quantity*Unitprice)*0.1 ) as 'Salary'
from Employees e join Orders o on o.EmployeeID=e.EmployeeID 
join [Order Details] d on d.OrderID=o.OrderID
group by e.EmployeeID,FirstName,LastName
order by SUM(UnitPrice*Quantity) desc
--6.	Danh sách các customer ứng với tổng tiền các hoá đơn được lập từ 31/12/1996 đến 1/1/1998.
select c.CustomerID, c.ContactName, sum(Quantity * UnitPrice) as TongTien
from Customers c join Orders o on c.CustomerID = o.CustomerID join [Order Details] od on o.OrderID = od.OrderID
where o.OrderDate between '1996-12-31' and '1998-1-1'
group by c.CustomerID, c.ContactName
order by CustomerID 
--Câu 7-- Danh sách các customer ứng với tổng tiền các hoá đơn, 
--mà các hóa đơn được lập từ 31/12/1996 đến 1/1/1998 và tổng tiền các hóa đơn >20000.
select c.CustomerID, c.CompanyName,sum(od.UnitPrice*od.Quantity) as 'Tong_Tien'
from Customers c join Orders o on o.CustomerID=c.CustomerID 
join [Order Details] od on od.OrderID=o.OrderID
where o.OrderDate between '12/31/1996' and '1/1/1998'
group by  c.CustomerID, c.CompanyName
having sum(od.UnitPrice*od.Quantity) > 20000
order by CustomerID
-- Hoặc --
select CustomerID, Tong_Tien=SUM(Quantity*UnitPrice)
from orders o join [Order Details] d on o.OrderID=d.OrderID
where OrderDate between '12/31/1996' and '1/1/1998'
group by CustomerID
having SUM(Quantity*UnitPrice*(1-Discount))>20000
-- hoặc--
select c.CustomerID, c.ContactName, sum(Quantity * UnitPrice) as TongTien
from Customers c join Orders o on c.CustomerID = o.CustomerID join [Order Details] od on o.OrderID = od.OrderID
where o.OrderDate between '1996-12-31' and '1998-1-1'
group by c.CustomerID, c.ContactName
having sum(Quantity * UnitPrice) > 20000
order by CustomerID
--Câu 8-- Danh sách các customer ứng với tổng số hoá đơn, tổng tiền các hoá đơn, 
--mà các hóa đơn được lập từ 31/12/1996 đến 1/1/1998 và tổng tiền các hóa đơn >20000. 
--Thông tin được sắp xếp theo CustomerID, cùng mã thì sắp xếp theo tổng tiền giảm dần.
select c.CustomerID, c.CompanyName,COUNT(*) as CountOfOrder,sum(od.UnitPrice*od.Quantity) as Tong_Tien
from Customers c join Orders o on o.CustomerID=c.CustomerID 
join [Order Details] od on od.OrderID=o.OrderID
where o.OrderDate between '12/31/1996' and '1/1/1998'
group by  c.CustomerID, c.CompanyName
having sum(od.UnitPrice*od.Quantity) > 20000
order by c.CustomerID, sum(od.UnitPrice*od.Quantity) desc
-- hoặc--
select o.CustomerID, c.ContactName, count(o.orderID) as TongSoHD, sum(Quantity * UnitPrice) as TongTien
from Customers c join Orders o on c.CustomerID = o.CustomerID join [Order Details] od on o.OrderID = od.OrderID
where o.OrderDate between '1996-12-31' and '1998-1-1'
group by o.CustomerID, c.ContactName
having sum(Quantity * UnitPrice) > 20000
order by CustomerID, sum(Quantity * UnitPrice) desc
--Câu 9-- Danh sách các Category có tổng số lượng tồn (UnitsInStock) lớn hơn 300, 
--đơn giá trung bình nhỏ hơn 25. Thông tin kết quả bao gồm CategoryID, CategoryName, Total_UnitsInStock, Average_Unitprice.
select c.CategoryID,CategoryName,
SUM(UnitsInStock) as So_Luong_Ton,
AVG(UnitPrice) as Don_Gia_Trung_Binh
from Categories c join Products p 
on p.CategoryID = c.CategoryID
group by c.CategoryID,CategoryName
having SUM(UnitsInStock)>300 and AVG(UnitPrice)<25
-- Câu 10: Danh sách các loại sản phẩm (Category) có tổng số sản phẩm (product) nhỏ hơn 10. 
-- Thông tin kết quả bao gồm CategoryID, CategoryName, 
-- TotalOfProducts. Được sắp xếp theo CategoryName, cùng tên loại theo 
-- TotalOfProducts giảm dần.
select p.CategoryID, c.CategoryName, count(ProductID) as Cout_order
from Products p join Categories c on p.CategoryID = c.CategoryID
group by p.CategoryID, c.CategoryName
having count(p.productID) > 10
/*11.	Danh sách các product theo từng CategoryName, 
thông tin bao gồm: CategoryName, Unitprice, UnitsinStock. 
Có dùng mệnh đề COMPUTE để liệt kê đơn giá trung bình, tổng số lượng tồn (sum of UnitsinStock) theo từng CategoryName. */


select c.CategoryName, avg(p.UnitPrice) as 'Đơn giá trung bình', sum(p.UnitsInStock) as 'Số lượng tồn'
from Products p join Categories c
on p.CategoryID = c.CategoryID
group by c.CategoryName
order by CategoryName

--Câu 12-- Danh sách các Customer ứng với tổng tiền của các hóa đơn ở từng tháng. 
--Thông tin bao gồm CustomerID, CompanyName, Month_Year, Total. 
--Trong đó Month_year là tháng và năm lập hóa đơn, Total là tổng của Unitprice* Quantity, 
--có thống kế tổng của total theo từng Customer và Month_Year . (có dùng COMPUTE)
select c.CustomerID,CompanyName,
CONVERT(char(2),MONTH(OrderDate))+'/'+CONVERT(char(4),year(OrderDate)) 
as Thang_Nam,sum(UnitPrice*Quantity) as Tong_Tien
from dbo.Customers c join dbo.Orders o on o.CustomerID=c.CustomerID 
join dbo.[Order Details] d on d.OrderID=o.OrderID
group by c.CustomerID,CompanyName,
CONVERT(char(2),MONTH(OrderDate))+'/'+CONVERT(char(4),year(OrderDate))
order by c.CustomerID,CONVERT(char(2),MONTH(OrderDate))+'/'+CONVERT(char(4),year(OrderDate))
-- hoặc
select o.CustomerID, c.CompanyName, month(o.OrderDate) as THANG, year(o.OrderDate) as NAM, sum(Quantity*UnitPrice) as Total
from Orders o join [Order Details] od on o.OrderID = od.OrderID join Customers c on o.CustomerID = c.CustomerID
group by o.CustomerID, c.CompanyName, month(o.OrderDate), year(o.OrderDate)

--Câu 13-- Cho biết Employees nào bán được nhiều tiền nhất trong 7 của năm 1997
select top 1 e.EmployeeID,hotenNV=LastName+' '+FirstName,
SUM(UnitPrice*Quantity) as tongtien
from Employees e join dbo.Orders o on o.EmployeeID=e.EmployeeID 
join dbo.[Order Details] d on d.OrderID=o.OrderID
where OrderDate between '1/1/1997' and '7/31/1997'
group by e.EmployeeID,FirstName,LastName
order by SUM(UnitPrice*Quantity) desc
-- hoặc
select top 1 o.EmployeeID, sum (Quantity*UnitPrice) as TongTien
from Orders o join [Order Details] od on o.OrderID = od.OrderID
where o.OrderDate between '1997-01-01' and '1997-07-31'
group by o.EmployeeID
order by TongTien desc
--Hoặc--
select e.EmployeeID,hotenNV=LastName+' '+FirstName,SUM(UnitPrice*Quantity) as tongtien
from dbo.Employees e join dbo.Orders o on o.EmployeeID=e.EmployeeID 
join dbo.[Order Details] d on d.OrderID=o.OrderID
where OrderDate between '1/1/1997' and '7/31/1997'
group by e.EmployeeID,FirstName,LastName
having SUM(UnitPrice*Quantity) >= all(select SUM(UnitPrice*Quantity)
from dbo.[Order Details] dd join dbo.Orders oo on oo.OrderID=dd.OrderID
where OrderDate between '1/1/1997' and '7/31/1997'
group by EmployeeID)
--14.	Danh sách 3 khách có nhiều đơn hàng nhất của năm 1996.
select top 3 o.CustomerID, sum (Quantity*UnitPrice) as TongTien
from Orders o join [Order Details] od on o.OrderID = od.OrderID
group by o.CustomerID
order by TongTien desc

--15.	Cho biết khách hàng nào có số lần mua hàng lớn hơn 10 trong năm 1997.
select o.CustomerID, count(o.OrderID) as SoLanMuaHang
from Orders o join [Order Details] od on o.OrderID = od.OrderID
where year(o.OrderDate) = 1997
group by o.CustomerID
having count(o.OrderID) > 10