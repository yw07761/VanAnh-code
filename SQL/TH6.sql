--Hồ Hoàng Vân Anh_20098521_TH6
--1. Liệt kê các customer lập hóa đơn trong tháng 7/1997. Thông tin gồm
--CustomerID, CompanyName, Address, OrderID, Orderdate. Được sắp xếp theo
--Customerid, cùng CustomerID thì sắp xếp theo OrderDate giảm dần.
SELECT C.CustomerID, CompanyName, Address, OrderID, Orderdate 
FROM Customers C INNER JOIN Orders O
ON C.CustomerID = O.CustomerID
WHERE MONTH(OrderDate) =7 AND YEAR(OrderDate) = 1997
ORDER BY CustomerID,OrderDate DESC
--2. Liệt kê các customer có lập hóa đơn trong 15 ngày đầu tiên của 1/1997
SELECT * FROM Customers C INNER JOIN Orders O ON O.CustomerID = C.CustomerID
WHERE MONTH(OrderDate) =7 AND YEAR(OrderDate) = 1997 AND DAY(OrderDate) <=15
--3. Liệt kê danh sách các sản phẩm được giao vào ngày 16/7/1996
SET DATEFORMAT DMY
SELECT * FROM (([Products] p INNER JOIN [Order Details] od ON p.ProductID = od.ProductID)
INNER JOIN [Orders] o ON o.OrderID = od.OrderID)
WHERE OrderDate = '16/07/1996'
--4. Liệt kê danh sách các hóa đơn của các Customers mua hàng trong tháng 4, 9
--của năm 1997. Thông tin gồm Orderid, CompanyName, OrderDate, RequiredDate
--được sắp xếp theo CompanyName, cùng Companyname thì theo OrderDate giảm dần.
SELECT o.OrderID, c.CustomerID, o.OrderDate, o.RequiredDate 
FROM Customers c INNER JOIN Orders o 
ON o.CustomerID = c.CustomerID
WHERE MONTH(o.OrderDate) IN (4, 9) AND YEAR(o.OrderDate) =1997
ORDER BY c.CompanyName DESC, o.OrderDate DESC
--5 Liệt kê danh sách các hóa đơn do nhân viên có Lastname là Fuller lập.
SELECT * FROM Orders o INNER JOIN Employees e 
ON e.EmployeeID = o.EmployeeID
WHERE e.LastName LIKE 'Fuller'
--6 Liệt kê danh sách các Products do nhà cung cấp (supplier) có mã 1,3,6 bán
-- được trong tháng quý 2 của năm 1997, được sắp xếp theo mã nhà cung cấp
-- (SupplierID), cùng mã nhà cung cấp thì sắp xếp theo ProductID.
SELECT * FROM (((Products p INNER JOIN Suppliers s ON s.SupplierID = p.SupplierID)
INNER JOIN [Order Details] od ON od.ProductID = p.ProductID)
INNER JOIN Orders o ON o.OrderID= od.OrderID)
WHERE p.SupplierID IN (1,3,6) AND MONTH(o.OrderDate) IN (6,7) AND YEAR(o.OrderDate) = 1997
ORDER BY p.SupplierID, p.ProductID
--7 Liệt kê danh sách các Products do nhà cung cấp (supplier) có mã 1,3,6 bán
SELECT * FROM Products p INNER JOIN [Order Details] od ON od.ProductID = p.ProductID
WHERE p.SupplierID IN (1,3,6)
--8 Liệt kê danh sách các Products mà hóa đơn có OrderID là 10248 đã mua.
SELECT * FROM ((Products p INNER JOIN [Order Details] od ON od.ProductID = p.ProductID)INNER JOIN Orders o 
ON o.OrderID = od.OrderID)
WHERE od.OrderID = '10248'
--9 Liệt kê danh sách các Employers đã lập các hóa đơn trong tháng 7 của năm 1996.
SELECT * FROM dbo.Employees e INNER JOIN dbo.Orders o ON o.EmployeeID = e.EmployeeID
WHERE  MONTH(o.OrderDate) = 7 AND YEAR(o.OrderDate) = 1996
--
SELECT * FROM Products p INNER JOIN [Order Details] od ON 
od.ProductID = p.ProductID
WHERE od.UnitPrice = p.UnitPrice                        
-- 10.Danh sách các sản phẩm bán trong ngày thứ 7 và chủ nhật của tháng 12 năm
-- 1996, thông tin gồm [ProductID], [ProductName], OrderID, OrderDate,
-- CustomerID, Unitprice, Quantity, ToTal= Quantity*UnitPrice. Được sắp xếp
-- theo ProductID, cùng ProductID thì sắp xếp theo Quantity giảm dần.
SELECT p.ProductID, p.ProductName, od.OrderID, o.OrderDate, o.CustomerID, p.UnitPrice, od.Quantity, 
ToTal= od.Quantity*p.UnitPrice
FROM ((Products p INNER JOIN [Order Details] od 
ON od.ProductID = p.ProductID)
INNER JOIN Orders o 
ON o.OrderID = od.OrderID)
WHERE datename(WEEKDAY, orderdate) = 'Monday' or datename(WEEKDAY, orderdate) = 'Sunday' 
and MONTH (OrderDate) = 12 and YEAR (OrderDate) = 1996
--where MONTH(OrderDate)=6 and YEAR(OrderDate)=1997)--
--where month(orderdate) in ('1','2','3') and year(orderdate)=1998
-- 11. Liệt kê bảng doanh thu của mỗi nhân viên theo từng hóa đơn trong năm 1996
-- gồm EmployeeID, EmployName, OrderID, Orderdate, Productid, quantity,
-- unitprice, ToTal=quantity*unitprice.
SELECT e.EmployeeID, e.LastName, o.OrderID, o.OrderDate, Productid, quantity, unitprice,
ToTal=quantity*unitprice
FROM ((Employees e INNER JOIN Orders o 
ON o.EmployeeID = e.EmployeeID) INNER JOIN [Order Details] od ON od.OrderID = o.OrderID)
-- 12.Danh sách các đơn hàng sẽ được giao trong các thứ 2 của tháng 12 năm 1996.
SELECT * FROM ((Products p INNER JOIN [Order Details] od 
ON od.ProductID = p.ProductID)
INNER JOIN Orders o 
ON o.OrderID = od.OrderID)
WHERE datename(WEEKDAY, orderdate) = 'Monday'
and MONTH (OrderDate) = 12 and YEAR (OrderDate) = 1996
-- 13.Liệt kê danh sách các nhân viên chưa lập hóa đơn (dùng LEFT JOIN/RIGHTJOIN).
SELECT e.EmployeeID,e.FirstName,e.LastName
FROM Employees e 
LEFT JOIN Orders o
ON e.EmployeeID = o.EmployeeID
WHERE e.EmployeeID not in (SELECT EmployeeID FROM Orders WHERE EmployeeID = e.EmployeeID)
--WHERE o.EmployeeID IS NULL
--ORDER BY e.EmployeeID
--14.Liệt kê danh sách các sản phẩm chưa bán được (dùng LEFT JOIN/RIGHT JOIN).
SELECT p.ProductID,p.ProductName
FROM Products p 
LEFT JOIN [Order Details] od
ON p.ProductID = od.OrderID 
WHERE p.ProductID not in (SELECT od.ProductID FROM [Order Details]  
JOIN Orders o ON o.OrderID=od.OrderID)
--15.Liệt kê danh sách các khách hàng chưa mua hàng lần nào (dùng LEFT JOIN/RIGHT JOIN).
SELECT c.CustomerID, c.CompanyName, c.ContactName
FROM Customers c
LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
WHERE c.CustomerID NOT IN (SELECT CustomerID FROM Orders WHERE CustomerID = c.CustomerID)
--WHERE YEAR(OrderDate) = 1996 AND MONTH(OrderDate) = 7)
ORDER BY C.CustomerID
-------- c2 ---------
SELECT C.CustomerID, C.CompanyName, C.ContactName, O.OrderDate
FROM Customers C
LEFT JOIN Orders O ON C.CustomerID = O.CustomerID 
--AND YEAR(O.OrderDate) = 1996 AND MONTH(O.OrderDate) = 7
WHERE O.OrderDate IS NULL
ORDER BY C.CustomerID
/*
--Danh sách các Customers chưa mua hàng trong năm 1997-- k dùng left join/ right join
select *
from Customers
where CustomerID not in
(select c.CustomerID
from Customers c join Orders o on o.CustomerID=c.CustomerID
where year(o.OrderDate) = 1997)
--Danh sách các Employes không lập hóa đơn vào ngày hôm nay--
select *
from dbo.Employees
where EmployeeID not in
(select e.EmployeeID
from  dbo.Employees e join dbo.Orders o on e.EmployeeID=o.EmployeeID
where o.OrderDate = GETDATE())
*/

