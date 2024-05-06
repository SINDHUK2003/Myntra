# MyntraDemo Backend

This is the backend replica of the Myntra, which is a simplified e-commerce platform. It provides RESTful APIs for managing user profiles, including login, profile creation, retrieval, update, and deletion.

## Technologies Used

- Java
- Spring Boot
- MySQL

- To Download JDK : [https://www.oracle.com/in/java/technologies/downloads/]
- To Download Spring Boot Project File : [https://start.spring.io/]
- To Download MySQL : [https://www.mysql.com/downloads/]
- To Download IntelliJ IDEA : [https://www.jetbrains.com/idea/download/]


1. **Clone the repository:**

   ```bash
   git clone

   
2. **Navigate to MyntrademoApplication**

   Run MyntrademoApplication.java

3. **Checks**

   - Profile
   ```bash
   http://localhost:8080/createProfile

   http://localhost:8080/login

   http://localhost:8080/getProfile/1

   http://localhost:8080/deleteProfile/1

   http://localhost:8080/deleteProfile/1


   - Mobile Number
   ```bash
   http://localhost:8080/createMobile

   http://localhost:8080/getMobile/302

   http://localhost:8080/updateMobile/302

   http://localhost:8080/deleteMobile/302


  - Location
  ```bash
  http://localhost:8080/createLocation

  http://localhost:8080/getLocation/1

  http://localhost:8080/deleteLocation/1



  - Product
  ```bash
  http://localhost:8080/createProduct

  http://localhost:8080/getProduct/1

  http://localhost:8080/updateProduct/1

  http://localhost:8080/deleteProduct/1



  - Cart
  ```bash
  http://localhost:8080/createCart

  http://localhost:8080/getCart/1

  http://localhost:8080/getCartByProfileId/1

  http://localhost:8080/updateCart/1

  http://localhost:8080/deleteCart/1



  - Category
  ```bash
  http://localhost:8080/createCategory

  http://localhost:8080/getCategory/2

  http://localhost:8080/addSubcategory/Shoes

  http://localhost:8080/deleteSubcategory/Shoes

  http://localhost:8080/getCategory/2



  - Gallery
  ```bash
  http://localhost:8080/createGallery

  http://localhost:8080/getGallery/1

  http://localhost:8080/getByType/review

  http://localhost:8080/updateGallery/1

  http://localhost:8080/deleteGallery/1



  - Review
  ```bash
  http://localhost:8080/createReview

  http://localhost:8080/getReview/1

  http://localhost:8080/getAllReviews

  http://localhost:8080/updateReview/1

  http://localhost:8080/deleteReview/1





















