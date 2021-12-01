-- Hồ Hoàng Vân Anh -- 20098521
-- Tuần 4
-- Câu 3
-- Câu 3.a Tăng đơn giá bán lên 5% cho các sản phẩm có mã là 2
select * from [Order Details] where ProductID = 2
Update [Order Details] set UnitPrice=UnitPrice*1.05 where ProductID = 2
-- Câu 3.b Tăng số lượng tồn lên 100 cho các sản phẩm có nhóm mặt hàng là 2 của nhà cung cấp có mã là 2
select * from [Products] where CategoryID = 2 and  SupplierID = 2
Update [Products] set UnitsInStock=100 where CategoryID = 2 and  SupplierID = 2
-- Câu 3.e Tăng đơn giá gốc lên 2% cho những sản phẩm mà phần tên có chứa chữ u
select * from Products where ProductName like '%u%'
Update Products set UnitPrice=UnitPrice*1.02 where ProductName  like '%u%'
-- Câu 4
--cau 4.a Xóa các sản phẩm có SLTon <2
select * from [Products] where UnitsInStock < 2
Delete from [Products] Where UnitsInStock < 2
-- Tuần 5
-- BÀI TẬP 1: LỆNH SELECT – TRUY VẤN ĐƠN GIẢN
-- 1. Liệt kê thông tin của tất cả các sản phẩm (Products)
SELECT * FROM dbo.Products
-- 2. Liệt kê danh sách các khách hàng (Customers). Thông tin bao gồm
-- CustomerID, CompanyName, City, Phone.
SELECT CustomerID, CompanyName, City, Phone FROM Customers
--3. Liệt kê danh sách các sản phẩm (Products). Thông tin bao gồm ProductId, ProductName, UnitPrice.
SELECT ProductID, ProductName, UnitPrice FROM Products
-- 4. Liệt kê danh sách các nhân viên (Employees). Thông tin bao gồm EmployeeId,
-- EmployeeName, Phone, Age. Trong đó EmployeeName được ghép từ
-- LastName và FirstName; Age là tuổi được tính từ năm hiện hành (GetDate()) và năm của Birthdate.
SELECT EmployeeID, LastName+FirstName 
AS EmployeeName ,HomePhone 
AS Phone, YEAR(GETDATE()) - YEAR(BirthDate) 
AS Age FROM Employees
-- 5. Liệt kê danh sách các khách hàng (Customers) có ContactTitle bắt đầu bằng chữ O
SELECT * FROM Customers
WHERE ContactTitle LIKE 'O%'
-- 6. Liệt kê danh sách khách hàng (Customers) ở thành phố LonDon, Boise và Paris
SELECT * FROM Customers
WHERE City = 'LonDon' OR City = 'Boise' OR City = 'Paris'
-- 7. Liệt kê danh sách khách hàng (Customers) có tên bắt đầu bằng chữ V mà ở thành phố Lyon
SELECT *FROM Customers
WHERE CompanyName LIKE 'V%' AND City = 'Lyon'
-- 8. Liệt kê danh sách các khách hàng (Customers) không có số fax
SELECT * FROM Customers
WHERE Fax IS NULL
-- 9. Liệt kê danh sách các khách hàng (Customers) có số Fax
SELECT * FROM Customers
WHERE Fax IS NOT NULL
-- 10.Liệt kê danh sách nhân viên (Employees) có năm sinh <=1960
SELECT * FROM Employees
WHERE YEAR(BirthDate) <= 1960
-- 11.Liệt kê danh sách các sản phẩm (Products) có từ ‘Boxes’ trong cột QuantityPerUnit.
SELECT * FROM Products
WHERE QuantityPerUnit LIKE '%Boxes%'
-- 12.Liệt kê danh sách các sản phẩm (Products) có Unitprice lớn hớn 10 và nhỏ hơn 15.
SELECT * FROM Products
WHERE UnitPrice > 10 AND UnitPrice < 15
-- 13.Liệt kê danh sách các hóa đơn (orders) có OrderDate được lập trong tháng 9 năm 1996. 
-- Được sắp xếp theo mã khách hàng, cùng mã khách hàng sắp xếp theo ngày lập hóa đơn giảm dần.
SELECT * FROM Orders
WHERE YEAR(OrderDate) = 1996 AND MONTH(OrderDate) = 9
-- 14.Liệt kê danh sách các hóa đơn (Orders) được lập trong quý 4 năm 1997. Thông tin gồm OrderID, OrderDate, Customerid, EmployeeID. 
-- Được sắp xếp theo tháng của ngày lập hóa đơn.
SELECT ProductID, ProductName, UnitPrice, UnitsInStock, UnitsInStock*UnitPrice AS TotalAccount FROM Products
-- 15.Liệt kê danh sách các hóa đơn (Orders) được lập trong trong ngày thứ 2 và thứ 5 của tháng 12 năm 1997. 
-- Thông tin gồm OrderID, OrderDate, Customerid, EmployeeID, WeekDayOfOrdate (Ngày thứ mấy trong tuần).
select OrderID, OrderDate, datename(WEEKDAY, orderdate) as Thu from Orders
where (datename(WEEKDAY, orderdate) = 'Monday' or datename(WEEKDAY, orderdate) = 'Sunday')
and (MONTH (OrderDate) =12 and YEAR (OrderDate) = 1997)
-- 16.Liệt kê danh sách các sản phẩm (Products) ứng với tiền tồn vốn. Thông tin bao gồm ProductId, ProductName, Unitprice, UnitsInStock, TotalAccount. 
-- Trong đó TotalAccount= UnitsInStock * Unitprice. Được sắp xếp theo TotalAcount giảm dần.
SELECT ProductID, ProductName, UnitPrice, UnitsInStock, UnitsInStock*UnitPrice AS TotalAccount FROM Products
-- 17.Liệt kê danh sách 5 customers có city bắt đầu ‘M’.
SELECT TOP 5 * FROM Customers
WHERE City LIKE 'M%'
-- 18.Liệt kê danh sách 2 employees có tuổi lớn nhất. Thông tin bao gồm EmployeeID, EmployeeName, Age. 
-- Trong đó, EmployeeName được ghép từ LastName và FirstName; Age là năm hiện hành trừ năm sinh.
SELECT TOP 2 EmployeeID, LastName+FirstName AS EmployeeName, YEAR(GETDATE())-YEAR(BirthDate) AS Age FROM Employees
ORDER BY Age DESC
-- 19.Liệt kê danh sách các Products có số lượng tồn nhỏ hơn 5.
SELECT * FROM dbo.Products
WHERE UnitsInStock < 5
-- 20.Liệt kê danh sách các Orders gồm OrderId, Productid, Quantity, Unitprice,
-- Discount, ToTal = Quantity * unitPrice – 20%*Discount.
SELECT OrderID, ProductID, Quantity, UnitPrice, Discount, Quantity*UnitPrice - Discount*0,2 AS ToTal FROM dbo.[Order Details]