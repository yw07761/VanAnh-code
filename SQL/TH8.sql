-- Hồ Hoàng Vân Anh_20098521_TH8
--Câu 1: Các product có đơn giá bán lớn hơn đơn giá bán trung bình của các product.
--Thông tin gồm ProductID, ProductName, Unitprice (Bên bảng Order Details).
select ProductID, ProductName, Unitprice
from Products
where UnitPrice > (select AVG(UnitPrice) from Products)

-- Câu 2: Các product có đơn giá lớn hơn đơn giá trung bình của các product có ProductName bắt đầu là ‘N’--
select ProductID, ProductName, UnitPrice
from Products
where UnitPrice > (select AVG(UnitPrice) from Products where ProductName like 'N%')

-- Câu 3: Cho biết những sản phẩm có tên bắt đầu bằng chữ N và đơn giá > đơn giá của sản phẩm khác--
--don gia >  don gia cua bat ki san pham nao
select ProductID, ProductName, UnitPrice
from Products
where ProductName like 'N%' and UnitPrice > 
ANY(select UnitPrice from Products where ProductName not like 'N%')

--don gia > don gia cua tat ca cac san pham
select ProductID, ProductName, UnitPrice
from Products
where ProductName like 'N%' and UnitPrice >= ALL(select UnitPrice from Products where ProductName like 'N%')

-- Câu 4: Danh sách các products đã từng có khách hàng đặt hàng (tức là ProductId có trong Order Details). 
-- Thông tin bao gồm ProductId, ProductName, Unitprice
select distinct p.ProductID,ProductName,p.UnitPrice
from Products p join [Order Details] d on d.ProductID=p.ProductID
--Hoặc--
SELECT ProductID, ProductName, UnitPrice
FROM Products
WHERE ProductID IN (SELECT ProductID FROM [Order Details]) 

-- Câu 5: Danh sách các products có đơn giá nhập lớn hơn đơn giá bán nhỏ nhất của tất cả các Products
SELECT ProductID, ProductName, UnitPrice
FROM Products
WHERE UnitPrice > (SELECT MIN(UnitPrice) FROM [Order Details])

-- Câu 6: Danh sách các hóa đơn của những Customers ở thành phố LonDon và Madrid đã mua.
SELECT OrderID, CustomerID
FROM Orders
WHERE CustomerID IN (SELECT CustomerID FROM Customers WHERE city='LonDon' OR city='Marid')

-- Câu 7: Danh sách các products có đơn vị tính có chữ Box 
--và có đơn giá mua nhỏ hơn đơn giá trung bình của tất cả các Products.
SELECT ProductID, ProductName, QuantityPerUnit, UnitPrice
FROM Products
WHERE QuantityPerUnit LIKE '%box%' AND UnitPrice < (SELECT AVG(UnitPrice) FROM Products)

-- Câu 8: Danh sách các Products có số lượng (Quantity) bán được lớn nhất.--

select productID, ProductName
from Products
where productID = (select top 1 productID from [Order Details] od group by ProductID order by sum(Quantity) desc)
-- Câu 9: Danh sách các Customer chưa từng lập hóa đơn 
--(viết bằng ba cách: dùng NOT EXISTS, dùng LEFT JOIN, dùng NOT IN )

--su dung NOT EXISTS
SELECT C.CustomerID, CompanyName
FROM  Customers C
WHERE NOT EXISTS (SELECT OrderID, O.CustomerID FROM Orders O WHERE C.CustomerID=O.CustomerID)


--su dung LEFT JOIN
SELECT C.CustomerID, CompanyName, OrderID, O.CustomerID
FROM Customers C LEFT OUTER JOIN Orders O ON C.CustomerID=O.CustomerID
WHERE O.CustomerID IS NULL 
-- hoặc
select *
from Customers c left join Orders o on c.CustomerID = o.CustomerID 
where o.CustomerID is null
order by o.CustomerID
--su dung NOT IN
SELECT CustomerID, CompanyName
FROM Customers
WHERE CustomerID NOT IN (SELECT CustomerID FROM Orders)


--Danh sách các hóa đơn mua những Products có giá bán từ 200 đến 400--
SELECT OrderID, CustomerID, OrderDate
FROM Orders
WHERE OrderID IN (SELECT OrderID FROM [Order Details] WHERE UnitPrice BETWEEN 200 AND 400)

--Cho biết các sản phẩm có đơn giá bán cao nhất--
SELECT ProductID, ProductName, UnitPrice
FROM Products
WHERE UnitPrice >= ALL(SELECT UnitPrice FROM Products)

-- Câu 10: Cho biết các sản phẩm có đơn vị tính có chứa chữ box và có đơn giá bán cao nhất.
select * from Products
where UnitPrice >= all (select UnitPrice from Products where QuantityPerUnit like '%box%') and QuantityPerUnit like '%box%'

-- Câu 11: Danh sách các products có đơn giá bán lớn hơn đơn giá bán trung bình 
--của các Products có ProductId<=5
select ProductID, ProductName, UnitPrice
from Products
where UnitPrice > (select avg(UnitPrice) from [Order Details] where ProductID <= 5)

--Danh sách các Customers và các Employees không ở cùng thành phố
--khach hang khong o cung thanh pho voi nhan vien
select CustomerID, City
from Customers
where City not in (select City from Employees)
---nhan vien khong o cung thanh pho voi khach hang
select EmployeeID, City
from Employees
where City not in (select City from Customers)
---gom lai
select City
from Customers
where City not in (select City from Employees)
union
select City
from Employees
where City not in (select City from Customers)

-- Câu 12: Cho biết những sản phẩm nào có tổng số lượng bán được lớn hơn số lượng trung bình bán ra
select P.ProductID, ProductName, TongSL=sum(Quantity)
from Products P, [Order Details] D
where P.ProductID=D.ProductID
group by P.ProductID, ProductName
	having sum(Quantity) > (select sum(quantity)/(select count(ProductID) from Products) from [Order Details])
order by TongSL

-- Câu 13: Liệt kê danh sách các khách hàng mua các hóa đơn mà các hóa đơn này chỉ mua những sản phẩm có mã >=3
select distinct CustomerID
from Orders
where OrderID in ( select OrderID from [Order Details] where ProductID >=3)

--Liệt kê danh sách các khách hàng mà các khách hàng này mua các hóa đơn
--do các nhân viên lập hóa đơn ở cùng thành phố với khách hàng
select distinct c.CustomerID, c.ContactName, c.city, o.EmployeeID
from Orders o join Customers c
on o.CustomerID = c.CustomerID
where c.city in (select city from Employees e where e.EmployeeID = o.EmployeeID)

-- Danh sách các Customers mà các Customers đã mua hàng trong tháng 7 hoặc 9 năm 1997
select CustomerID, CompanyName 
from Customers
where CustomerID in (select CustomerID from Orders where (Month(OrderDate) = '7' or Month(OrderDate) = '9') and YEAR(OrderDate)='1997')
-- 17.Danh sách các Customers mà các Customers đã mua hàng trong tháng 7, 9 năm 1997
select CustomerID, companyname, ContactName
from Customers
where CustomerID in (select CustomerID from Orders where month(OrderDate) in (7, 9) and year(OrderDate)=1997)
-- Câu 17: Liệt kê danh sách các Customers chưa mua hàng trong năm 1997
select CustomerID, CompanyName 
from Customers
where CustomerID not in (select CustomerID from Orders where  YEAR(OrderDate)='1997')

-- Câu 19: Danh sách các City có nhiều hơn 3 customer.--
select City, COUNT(CustomerID) as SoKH from Customers
group by City
having COUNT(CustomerID) > 3

-- 19.Tìm tất cả các Customers mua ít nhất 2 đơn hàng.
select CustomerID, CompanyName
from Customers
where CustomerID in (select Customerid from Orders group by CustomerID having count(OrderID) >=2)
--Liệt kê danh sách các sản phẩm có đơn giá lớn hơn đơn giá của tất cả các sản phẩm
-- có tên bắt đầu bằng chữ B.
Select ProductId, ProductName, UnitPrice from [Products]
Where Unitprice>ALL (Select Unitprice from [Products] where
ProductName like 'B%')


--bai tap 5:
--cau 1:
select distinct city
from Customers
union all
select distinct city
from Employees
--74 rows
--cau 2:
select distinct Country
from Customers
union all
select distinct Country
from Employees
--23 rows
--cau 3:
select c.CustomerID, c.CompanyName, c.Address, c.Phone
from Customers c
union all
select convert(nchar(5),e.EmployeeID), e.LastName +' '+e.FirstName as FullName, e.Address, e.HomePhone
from Employees e
--100 rows
--cau 4:

--cau 5:
select * from Customers c where CustomerID in
(select  o.CustomerID from Orders o inner join [Order Details] od on o.OrderID = od.OrderID
group by o.CustomerID having count(distinct od.ProductID) = (select count(ProductID) from Products))
-- 0 row