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

3. **localhost**

- Profile
     
   ```bash
   http://localhost:8080/createProfile

   http://localhost:8080/login

   http://localhost:8080/getProfile/{profileid}

   http://localhost:8080/deleteProfile/{profileid}

   http://localhost:8080/deleteProfile/{profileid}


- Mobile Number

   ```bash
   http://localhost:8080/createMobile

   http://localhost:8080/getMobile/{mobilenumberid}

   http://localhost:8080/updateMobile/{mobilenumberid}

   http://localhost:8080/deleteMobile/{mobilenumberid}


- Location
  
  ```bash
  http://localhost:8080/createLocation

  http://localhost:8080/getLocation/{locationid}

  http://localhost:8080/deleteLocation/{locationid}


- Product
  
  ```bash
  http://localhost:8080/createProduct

  http://localhost:8080/getProduct/{productid}

  http://localhost:8080/updateProduct/{productid}

  http://localhost:8080/deleteProduct/{productid}



- Cart
  
  ```bash
  http://localhost:8080/createCart

  http://localhost:8080/getCart/{cartid}

  http://localhost:8080/getCartByProfileId/{profileid}

  http://localhost:8080/updateCart/{cartid}

  http://localhost:8080/deleteCart/{cartid}



- Category
  
  ```bash
  http://localhost:8080/createCategory

  http://localhost:8080/getCategory/{categoryid}

  http://localhost:8080/addSubcategory/{maincategory}

  http://localhost:8080/deleteSubcategory/{maincategory}

  http://localhost:8080/getCategory/{categoryid}


- Gallery
  
  ```bash
  http://localhost:8080/createGallery

  http://localhost:8080/getGallery/{galleryid}

  http://localhost:8080/getByType/{type}

  http://localhost:8080/updateGallery/{galleryid}

  http://localhost:8080/deleteGallery/{galleryid}


- Review
  
  ```bash
  http://localhost:8080/createReview

  http://localhost:8080/getReview/{reviewid}

  http://localhost:8080/getAllReviews

  http://localhost:8080/updateReview/{reviewid}

  http://localhost:8080/deleteReview/{reviewid}


## ER DIAGRAM

<img width="1108" alt="Screenshot 2024-05-06 at 7 07 11 PM" src="https://github.com/SINDHUK2003/Myntra/assets/102289855/19c3d575-64df-4ab5-8200-2b6a1f9ef9a9">










