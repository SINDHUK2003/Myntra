CREATE TABLE Category (
    CategoryId INT AUTO_INCREMENT PRIMARY KEY,
    MainCategory VARCHAR(255),
    SubCategory1 VARCHAR(255),
    SubCategory2 VARCHAR(255),
    SubCategory3 VARCHAR(255),
    SubCategory4 VARCHAR(255),
    SubCategory5 VARCHAR(255)
);

CREATE TABLE Gallery (
    GalleryId INT AUTO_INCREMENT PRIMARY KEY,
    Iamge1 VARCHAR(255),
    Iamge2 VARCHAR(255),
    Iamge3 VARCHAR(255),
    Iamge4 VARCHAR(255),
    Iamge5 VARCHAR(255),
    Video1 VARCHAR(255),
    Viedo2 VARCHAR(255),
    Type VARCHAR(255)
);

CREATE TABLE Location (
    LocationId INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    BuildingNumber VARCHAR(255),
    Locality VARCHAR(255),
    District VARCHAR(255),
    Pincode INT,
    State VARCHAR(255),
    TypeOfAddress VARCHAR(255)
);

CREATE TABLE MobileNumber (
    MobileNumberId INT AUTO_INCREMENT PRIMARY KEY,
    CountryCode VARCHAR(255),
    MobileNumber VARCHAR(255),
    AlternateNumber VARCHAR(255)
);

CREATE TABLE Payment (
    PaymentId INT AUTO_INCREMENT PRIMARY KEY,
    TransactionID VARCHAR(255),
    PaymentType VARCHAR(255),
    PaymentStatus VARCHAR(255)
);

CREATE TABLE Profile (
    ProfileId INT AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(255),
    Email VARCHAR(255),
    Password VARCHAR(255),
    Gender VARCHAR(255),
    DateOfBirth DATE,
    mobilenumberid INT,
    locationid INT,
    FOREIGN KEY (mobilenumberid) REFERENCES MobileNumber(MobileNumberId),
    FOREIGN KEY (locationid) REFERENCES Location(LocationId)
);

CREATE TABLE Product (
    ProductId INT AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(255),
    Description VARCHAR(255),
    Brand VARCHAR(255),
    Size VARCHAR(255),
    MRP FLOAT,
    Stock INT,
    categoryid INT,
    galleryid INT,
    FOREIGN KEY (categoryid) REFERENCES Category(CategoryId),
    FOREIGN KEY (galleryid) REFERENCES Gallery(GalleryId)
);

CREATE TABLE Cart (
    CartId INT AUTO_INCREMENT PRIMARY KEY,
    ProfileId INT,
    ProductId INT,
    Quantity INT,
    CartStatus VARCHAR(255),
    FOREIGN KEY (ProfileId) REFERENCES Profile(ProfileId),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
);

CREATE TABLE Orders (
    OrderId INT AUTO_INCREMENT PRIMARY KEY,
    ProfileId INT,
    PaymentId INT,
    ProductId INT,
    OrderDate DATE,
    TotalAmount FLOAT,
    OrderStatus VARCHAR(255),
    FOREIGN KEY (ProfileId) REFERENCES Profile(ProfileId),
    FOREIGN KEY (PaymentId) REFERENCES Payment(PaymentId),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
);

CREATE TABLE Review (
    ReviewId INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(255),
    Description VARCHAR(255),
    Rating VARCHAR(255),
    ProfileId INT,
    ProductId INT,
    FOREIGN KEY (ProfileId) REFERENCES Profile(ProfileId),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
);
