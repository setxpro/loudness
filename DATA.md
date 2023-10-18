# MODELS

collaborator
---
name
middlename
email
login
password
phonenumber
dateOfBith
admissionDate
endDate
role
gender

customer
---
customerId int pk autoincrement FK >- order.customerId
fullname string
resumName string
phoneNumber string
whatsApp string
email string
dateOfbirh date

address
---
addressId int pk autoincrement
customerId int FK >- customer.customerId


product
---
productId int pk autoincrement
title string
price money
color string
brand  string
size string
resumDescription string
description
barCode string
code  string
categoryId FK >- categories.categoryId
tags string

orderLine
---
orderLineId int pk
productId int FK >- product.productId
orderId int FK >- order.orderId
quantity int

order
---
orderId int
customerId int
totalAmount money
orderStatusId int FK >- orderStatus.name

orderStatus
---
orderStatusId int
name string

cart
---
cartId int pk autoincrement FK >- product.productId
customerId int FK >- customer.customerId

liked
---
likedId int pk autoincrement
productId int FK >- product.productId
customerId int FK >- customer.customerId


assessments
---
assessmentsId int pk autoincrement
name string
email string
text string
totalRate int
prductId int FK >- product.productId
customerId int FK >- customer.customerId

categories
---
categoryId int pk autoincrement
title string