# Myntra Backend

This is the backend replica of the Myntra, which is a simplified e-commerce platform. It provides RESTful APIs for managing user profiles, Mobile Number, Location, Product, Orders, Reviews and Payment.


## Tech Stacks

- Java
- Spring Boot
- MySQL

## Requirements

- To Download JDK : [https://www.oracle.com/in/java/technologies/downloads/]
- To Download Spring Boot Project File : [https://start.spring.io/]
- To Download MySQL : [https://www.mysql.com/downloads/]
- To Download IntelliJ IDEA : [https://www.jetbrains.com/idea/download/]
- To Download Postman : [https://www.postman.com/downloads/]


1. **Clone the repository:**

   ```bash
   git clone https://github.com/SINDHUK2003/Myntra.git
   
2. **Navigate to MyntrademoApplication**

   Run MyntrademoApplication.java

3. **API ENDPOINTS**

Cart:

- POST - http://localhost:8080/createCart
- DELETE - http://localhost:8080/deleteCart/{cartid}
- GET - http://localhost:8080/getCart/{cartid}
- PUT - http://localhost:8080/updateCart/{cartid}
- GET - http://localhost:8080/getCartByProfileId/{profileid}
- DELETE - http://localhost:8080/deleteCartItem/{cartid}/{productid}
- PUT - http://localhost:8080/updateCartItemQuantity/{cartid}/{productid}
- GET - http://localhost:8080/cartTotal/{cartId}

Category:

- POST - http://localhost:8080/createCategory
- DELETE - http://localhost:8080/deleteCategory/{categoryid}
- GET - http://localhost:8080/getCategory/{categoryid}
- POST - http://localhost:8080/addSubcategory/{maincategory}
- DELETE - http://localhost:8080/deleteSubcategory/{maincategory}

Gallery:

- POST - http://localhost:8080/createGallery
- GET - http://localhost:8080/getGallery/{galleryid}
- DELETE - http://localhost:8080/deleteGallery/{galleryid}
- PUT - http://localhost:8080/updateGallery/{galleryid}
- GET - http://localhost:8080/getByType/{type}

Location:

- POST - http://localhost:8080/createLocation
- DELETE - http://localhost:8080/deleteLocation/{locationid}
- GET - http://localhost:8080/getLocation/{locationid}
- PUT - http://localhost:8080/updateLocation/{locationid}

MobileNumber:

- POST - http://localhost:8080/createMobile
- DELETE - http://localhost:8080/deleteMobile/{mobilenumberid}
- http://localhost:8080/getMobile/{mobilenumberid}
- PUT - http://localhost:8080/updateMobile/{mobilenumberid}

Order:

- POST - http://localhost:8080/createOrder
- GET - http://localhost:8080/getOrder/{orderId}
- PUT - http://localhost:8080/updateOrder/{orderId}
- DELETE - http://localhost:8080/deleteOrder/{orderId}

Payment:

- POST - http://localhost:8080/createPayment
- GET - http://localhost:8080/getPayment/{paymentid}
- DELETE - http://localhost:8080/deletePayment/{paymentid}
- GET - http://localhost:8080/getAllPayment

Product:

- POST - http://localhost:8080/createProduct
- DELETE - http://localhost:8080/deleteProduct/{productid}
- GET - http://localhost:8080/getProduct/{productid}
- PUT - http://localhost:8080/updateProduct/{productid}
- GET - http://localhost:8080/getAllProducts
- GET - http://localhost:8080/searchProductByName?productname={productname}

Profile:

- POST - http://localhost:8080/login
- POST - http://localhost:8080/createProfile
- DELETE - http://localhost:8080/deleteProfile/{profileid}
- GET - http://localhost:8080/getProfile/{profileid}
- PUT - http://localhost:8080/updateProfile/{profileid}
- POST - http://localhost:8080/resetPassword

Review:

- POST - http://localhost:8080/createReview
- GET - http://localhost:8080/getReview/{reviewid}
- DELETE - http://localhost:8080/deleteReview/{reviewid}
- GET - http://localhost:8080/getAllReviews
- PUT - http://localhost:8080/updateReview/{reviewid}

## ER DIAGRAM

![Myntra_Schema](https://github.com/SINDHUK2003/Myntra/assets/102289855/a1e433c5-c963-4f0c-8e56-206c31292f9f)









