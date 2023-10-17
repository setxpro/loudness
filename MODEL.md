# LOUDNESS TEC

## MODEL

<a href="https://app.quickdatabasediagrams.com/#/">Draw database diagram</a>

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


## FRAME

<a href="https://whimsical.com/loudness-tec-LRPdTPdetVMDjf9tRxDfgR">Access Software Architecture</a>

<a href="https://whimsical.com/loudness-tec-LRPdTPdetVMDjf9tRxDfgR">E-mail</a>

<a href="https://whimsical.com/loudness-tec-LRPdTPdetVMDjf9tRxDfgR">WhatsApp</a>

## SERVICES

<a href="https://www.facebook.com/business/m/get-started-meta-advertising?content_id=Bdm1TpXUtp53fbO&ref=sem_smb&utm_term=facebook%20e%20publicidade&gclid=Cj0KCQjw4bipBhCyARIsAFsieCxPez4y0xEL_JNtUFJzDuH33lJsJfQOyHZ48uUl-cvwP1vkSIKOezIaApmIEALw_wcB">Facebook</a>

<a href="https://business.instagram.com/shopping/?locale=pt_BR&content_id=JcW10T9nPnHQa66&ref=sem_smb&utm_term=dsa-1878220727685&gclid=Cj0KCQjw4bipBhCyARIsAFsieCwRBX8aVu3jSY3PKYM1mGGV83QaXmQdL7G4t-98kTuMZ570EIBZuNMaAvnSEALw_wcB">Instagram</a>

## Documentation