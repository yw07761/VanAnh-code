--ĐỖ GIA HUY _ 20090551
--Bài Thực Hành Tuần 7

--1. Danh sách các orders ứng với tổng tiền của từng hóa đơn. Thông tin bao gồm OrdersId, OrderDate, TotalAccount. 
--Trong đó TotalAccount là Sum của Quantity * Unitprice, kết nhóm theo OrderId
select d.OrderID,o.OrderDate, sum( Quantity* Unitprice) as TotalAcount
from [Order Details] d inner join Orders o
on d.OrderID= o.OrderID
group by d.OrderID,o.OrderDate

--2. Danh sách các orders ứng với tổng tiền của từng hóa đơn được lập ở thành phố(Shipcity) là ‘Madrid’.
--Thông tin bao gồm OrdersId, OrderDate, TotalAccount. 
--Trong đó TotalAccount là Sum của Quantity * Unitprice, kết nhóm theo OrderId.
select d.OrderID,o.OrderDate, sum( Quantity* Unitprice) as TotalAcount
from [Order Details] d inner join Orders o
on d.OrderID= o.OrderID
where ShipCity ='Madrid' 
group by d.OrderID,o.OrderDate

--3. Danh sách các Products có tổng số lượng lập hóa đơn lớn nhất. Thông tin gồm ProductID, ProductName, CountOfOrders.
select ProductID, ProductName, max(UnitsOnOrder) as CountOfOrders 
from Products
group by ProductID, ProductName

--4. Cho biết mỗi customers đã lập bao nhiêu hóa đơn. Thông tin gồm CustomerID, CompanyName, CountOfOrder. 
--Trong đó CountOfOrder (tổng số hóa đơn) được đếm (Count) theo từng Customers.
select c.CustomerID, CompanyName, COUNT(c.CustomerID) as CountOfOders
from Customers c inner join Orders o
on c.CustomerID= o.CustomerID
group by c.CustomerID, CompanyName

--5. Cho biết mỗi Employee đã lập được bao nhiêu hóa đơn, ứng với tổng tiền
select e.EmployeeID,  COUNT(distinct o.orderid) as Tong_HD, sum(quantity* unitprice) as TongTien
from 
(
	Employees e inner join Orders o on e.EmployeeID = o.EmployeeID
	inner join [Order Details] d on o.OrderID = d.OrderID
)
group by e.EmployeeID

--6. Liệt kê bảng lương của mỗi nhân viên theo từng tháng trong năm 1996 gồm 
--EmployeeID, EmployName, Month_Salary, Salary = sum(quantity*unitprice)*10%. 
--Được sắp xếp theo Month_Salary, cùmg Month_Salary thì sắp xếp theo Salary giảm dần
select e.EmployeeID, e.FirstName+' '+e.LastName as EmployName, MONTH(o.OrderDate) as Month_Salary,
sum(quantity*unitprice)*0.1 as Salary
from Employees e inner join Orders o on e.EmployeeID =o.EmployeeID
inner join [Order Details] d on o.OrderID=d.OrderID
where year(o.OrderDate) = 1996
group by e.FirstName+' '+e.LastName,e.EmployeeID,month(o.OrderDate)
order by (Salary) desc


--7. Danh sách các customer ứng với tổng tiền các hoá đơn, mà các hóa đơn được 
--lập từ 31/12/1996 đến 1/1/1998 và tổng tiền các hóa đơn >20000.
select c.CustomerID,c.CompanyName, sum(quantity*unitprice) as TongIien
from Customers c inner join Orders o on c.CustomerID=o.CustomerID
inner join [Order Details] d on o.OrderID = d.OrderID
where (o.OrderDate between '1996-12-31' and '1998-01-01')
group by c.CustomerID,c.CompanyName
having sum(quantity*unitprice) > 20000 

--8. Danh sách các customer ứng với tổng số hoá đơn, tổng tiền các hoá đơn, mà 
--các hóa đơn được lập từ 31/12/1996 đến 1/1/1998 và tổng tiền các hóa đơn >20000. 
--Thông tin được sắp xếp theo CustomerID, cùng mã thì sắp xếp theo tổng tiền giảm dần
select c.CustomerID,c.CompanyName,COUNT(o.OrderID) as TongSoHD, sum(quantity*unitprice) as TongTien
from Customers c inner join Orders o on c.CustomerID=o.CustomerID
inner join [Order Details] d on o.OrderID = d.OrderID
where (o.OrderDate between '1996-12-31' and '1998-01-01')
group by c.CustomerID,c.CompanyName
having sum(quantity*unitprice) > 20000 
order by (TongTien) desc

--9. Danh sách các Category có tổng số lượng tồn (UnitsInStock) lớn hơn 300, đơn giá trung bình nhỏ hơn 25.
--Thông tin kết quả bao gồm CategoryID, CategoryName, Total_UnitsInStock, Average_Unitprice.select c.CategoryID,c.CategoryName, sum(unitsinstock) as Total_UnitsInStock, AVG(unitprice) as Average_Unitpricefrom Categories c inner join Products p on c.CategoryID =p.CategoryIDgroup by c.CategoryID,c.CategoryNamehaving sum(unitsinstock) > 300 and AVG(unitprice) < 25--10.Danh sách các loại sản phẩm (Category) có tổng số sản phẩm (product) nhỏ hơn 10. 
--Thông tin kết quả bao gồm CategoryID, CategoryName, TotalOfProducts.
--Được sắp xếp theo CategoryName, cùng tên loại theo TotalOfProducts giảm dần.
select c.CategoryID,c.CategoryName, count(p.ProductID) as TotalOfProductsfrom Categories c inner join Products p on c.CategoryID =p.CategoryIDgroup by c.CategoryID,c.CategoryNamehaving count(p.ProductID) < 10--11.Liệt kê danh sách các sản phẩm bán trong quý 1 năm 1998 có tổng số lượng >200,--thông tin gồm [ProductID], [ProductName], SumofQuantityselect p.ProductID , p.ProductName, sum(Quantity) as SumOfQuatityfrom Products p inner join [Order Details] d on p.ProductID = d.ProductIDinner join Orders o on d.OrderID = o.OrderIDwhere datepart(quarter,orderdate) = 1 and year(orderdate) = 1998group by p.ProductID, p.ProductNamehaving sum(Quantity) > 200--12.Danh sách các Customer ứng với tổng tiền của các hóa đơn ở từng tháng. 
--Thông tin bao gồm CustomerID, CompanyName, Month_Year, Total. 
--Trong đó Month_year là tháng và năm lập hóa đơn, Total là tổng của Unitprice* Quantityselect c.CustomerID, c.CompanyName, month(o.orderdate) as Month,  year(o.orderdate) as Year,sum(quantity*unitprice) as Totalfrom Customers c inner join Orders o on c.CustomerID = o.CustomerIDinner join [Order Details] d on o.OrderID = d.OrderIDgroup by c.CustomerID,c.CompanyName, month(o.OrderDate), year(o.OrderDate)/*select o.CustomerID, c.CompanyName, month(o.OrderDate) as THANG, year(o.OrderDate) as NAM,
sum(Quantity*UnitPrice) as Total
from Orders o join [Order Details] od on o.OrderID = od.OrderID join Customers c on o.CustomerID = c.CustomerID
group by o.CustomerID, c.CompanyName, month(o.OrderDate), year(o.OrderDate)*/--13.Cho biết Employees nào bán được nhiều tiền nhất trong tháng 7 của năm 1997select top 1 e.EmployeeID, e.FirstName+' '+e.LastName as employName,sum(quantity*unitprice)as TongTienBan from Employees e inner join Orders o on e.EmployeeID = o.EmployeeID inner join [Order Details] d on o.OrderID = d.OrderIDwhere year(OrderDate) = 1997 and month(OrderDate)=7group by e.EmployeeID,  e.FirstName+' '+e.LastNameorder by (TongTienBan) desc select e.EmployeeID, e.FirstName+' '+e.LastName as employName,max(sum(quantity*unitprice))as TongTienBan from Employees e inner join Orders o on e.EmployeeID = o.EmployeeID inner join [Order Details] d on o.OrderID = d.OrderIDwhere year(OrderDate) = 1997 and month(OrderDate)=7group by e.EmployeeID,  e.FirstName+' '+e.LastName--14.Danh sách 3 khách có nhiều đơn hàng nhất của năm 1996select  top 3 c.CustomerID,c.CompanyName, COUNT(o.orderid) as TongDonHangfrom Customers c inner join Orders o on c.CustomerID = o.CustomerIDwhere year(OrderDate) = 1996 group by c.CustomerID,c.CompanyNameorder by (TongDonHang) desc--15.Tính tổng số hóa đơn và tổng tiền của mỗi nhân viên đã bán trong tháng 3/1997, có tổng tiền >4000,
--thông tin gồm [EmployeeID],[LastName], [FirstName], countofOrderid, sumoftotal.
select e.EmployeeID, e.FirstName+' '+e.FirstName as employName, COUNT(o.OrderID) as CountOfOrder,sum(quantity*unitprice)as TongTienBan from Employees e inner join Orders o on e.EmployeeID = o.EmployeeID inner join [Order Details] d on o.OrderID = d.OrderIDwhere year(OrderDate) = 1997 and month(OrderDate)=3group by e.EmployeeID,  e.FirstName+' '+e.FirstNamehaving sum(quantity*unitprice) >4000