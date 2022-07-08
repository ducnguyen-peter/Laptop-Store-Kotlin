package com.example.laptopstorekotlin.utils

const val TABLE_USER = "User"

const val COLUMN_USER_ID = "Id"
const val COLUMN_USER_NAME = "Username"
const val COLUMN_USER_PASSWORD = "Password"
const val COLUMN_USER_EMAIL = "Email"
const val COLUMN_USER_ADDRESS = "Address"
const val COLUMN_USER_TEL = "Tel"
const val COLUMN_USER_AVATAR = "Avatar"
const val COLUMN_USER_ROLE = "Role"

val allUserColumns = arrayOf(
    COLUMN_USER_ID, COLUMN_USER_NAME, COLUMN_USER_PASSWORD, COLUMN_USER_EMAIL, COLUMN_USER_ADDRESS,
    COLUMN_USER_TEL, COLUMN_USER_AVATAR, COLUMN_USER_ROLE
)

const val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "(" + COLUMN_USER_ID
        + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT," + COLUMN_USER_PASSWORD + " TEXT,"
        + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_ADDRESS + " TEXT," + COLUMN_USER_TEL + " TEXT,"
        + COLUMN_USER_AVATAR + " TEXT," + COLUMN_USER_ROLE + " TEXT )")
const val DROP_TABLE_USER = " DROP TABLE IF EXISTS $TABLE_USER"

//name and columns for table Electronics
const val TABLE_ELECTRONICS = "Electronics"
const val COLUMN_ELECTRONIC_ID = "Id"
const val COLUMN_ELECTRONICS_NAME = "Name"
const val COLUMN_ELECTRONICS_DESCRIPTION = "Description"
const val COLUMN_ELECTRONICS_UNIT_PRICE = "UnitPrice"
const val COLUMN_ELECTRONICS_QUANTITY = "Quantity"
const val COLUMN_ELECTRONICS_IMAGE_LINK = "ImageLink"

val allElectronicsColumns = arrayOf(
    COLUMN_ELECTRONIC_ID, COLUMN_ELECTRONICS_NAME, COLUMN_ELECTRONICS_DESCRIPTION,
    COLUMN_ELECTRONICS_UNIT_PRICE, COLUMN_ELECTRONICS_QUANTITY, COLUMN_ELECTRONICS_IMAGE_LINK
)

//name and columns for table Item
const val TABLE_ITEM = "Item"
const val COLUMN_ITEM_ID = "Id"
const val COLUMN_ITEM_UNIT_PRICE = "UnitPrice"
const val COLUMN_ITEM_QUANTITY = "Quantity"
const val COLUMN_ITEM_TOTAL_BUY = "TotalBuy"
const val COLUMN_ITEM_ELECTRONICS_ID = "ElectronicsId"

val allItemColumns = arrayOf(
    COLUMN_ITEM_ID, COLUMN_ITEM_UNIT_PRICE, COLUMN_ITEM_QUANTITY,
    COLUMN_ITEM_TOTAL_BUY, COLUMN_ITEM_ELECTRONICS_ID
)

//name and columns for table Category
const val TABLE_CATEGORY = "Category"
const val COLUMN_CATEGORY_ID = "Id"
const val COLUMN_CATEGORY_NAME = "Name"

val allCategoryColumns = arrayOf(COLUMN_CATEGORY_ID, COLUMN_CATEGORY_NAME)

//name and columns for table CategoryElectronics
const val TABLE_CATEGORY_ELECTRONICS = "CategoryElectronics"
const val COLUMN_CATEGORY_ELECTRONICS_CATEGORY_ID = "CategoryId"
const val COLUMN_CATEGORY_ELECTRONICS_ELECTRONICS_ID = "ElectronicsId"

val allCategoryElectronicsColumns =
    arrayOf(COLUMN_CATEGORY_ELECTRONICS_CATEGORY_ID, COLUMN_CATEGORY_ELECTRONICS_ELECTRONICS_ID)

//name and columns for table Cart
const val TABLE_CART = "Cart"
const val COLUMN_CART_ID = "Id"
const val COLUMN_CART_DISCOUNT = "Discount"
const val COLUMN_CART_USER_ID = "UserId"

//name and columns for table CartItem
const val TABLE_CART_ITEM = "CartItem"
const val COLUMN_CART_ITEM_AMOUNT = "Amount"
const val COLUMN_CART_ITEM_DISCOUNT = "Discount"
const val COLUMN_CART_ITEM_ITEM_ID = "ItemId"
const val COLUMN_CART_ITEM_CART_ID = "CartId"
val allCartItemColumns = arrayOf(
    COLUMN_CART_ITEM_AMOUNT,
    COLUMN_CART_ITEM_DISCOUNT,
    COLUMN_CART_ITEM_ITEM_ID,
    COLUMN_CART_ITEM_CART_ID
)

//
//key for SharedPreferences
const val KEY_USERNAME = "username"
const val KEY_EMAIL = "email"
const val KEY_TEL = "tel"
const val KEY_PASSWORD = "password"
const val KEY_CART_ID = "cartId"

//name and columns for table OrderOfUser
const val TABLE_ORDER = "[Order]"
const val COLUMN_ORDER_ID = "Id"
const val COLUMN_ORDER_STATUS = "Status"
const val COLUMN_ORDER_USER_ID = "UserId"
const val COLUMN_ORDER_DATE = "Date"

//name and columns for table OrderItem
const val TABLE_ORDER_ITEM = "OrderItem"
const val COLUMN_ORDER_ITEM_QUANTITY = "Quantity"
const val COLUMN_ORDER_ITEM_DISCOUNT = "Discount"
const val COLUMN_ORDER_ITEM_ORDER_ID = "OrderId"
const val COLUMN_ORDER_ITEM_ITEM_ID = "ItemId"

//name and columns for table Payment
const val TABLE_PAYMENT = "Payment"
const val COLUMN_PAYMENT_ID = "Id"
const val COLUMN_PAYMENT_TYPE = "Type"
const val COLUMN_PAYMENT_TYPENAME = "TypeName"
const val COLUMN_PAYMENT_AMOUNT = "Amount"
const val COLUMN_PAYMENT_CARD_ID = "CardID"
const val COLUMN_PAYMENT_DATE = "Date"
const val COLUMN_PAYMENT_ORDER_ID = "OrderId"

//name and columns for table Shipment
var TABLE_SHIPMENT = "Shipment"
var COLUMN_SHIPMENT_ID = "Id"
var COLUMN_SHIPMENT_TYPENAME = "TypeName"
var COLUMN_SHIPMENT_ORDER_ID = "OrderId"