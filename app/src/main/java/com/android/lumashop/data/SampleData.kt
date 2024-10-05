package com.android.lumashop.data

import com.android.lumashop.R
import com.android.lumashop.models.Product
import com.android.lumashop.models.Dimensions
import com.android.lumashop.models.User
import com.android.lumashop.models.UserRoleEnum
import com.android.lumashop.models.UserStatusEnum
import com.android.lumashop.models.VendorRatings
import java.util.Calendar
import java.util.Date

object SampleData {

    val productList = listOf(
        Product(
            id = "1",
            name = "Office Chair",
            description = "Comfortable office chair with ergonomic design",
            price = 150.0,
            category = "Chair",
            vendorId = "vendor_1",
            stockQuantity = 10,
            dimensions = Dimensions(50.0, 120.0, 50.0),
            material = "Leather",
            colorOptions = listOf("#FF0000", "#00FF00", "#0000FF"),
            weight = 12.5,
            assemblyRequired = true,
            productImages = listOf(R.drawable.recliner_chair,R.drawable.recliner_chair,R.drawable.recliner_chair),
            warrantyPeriod = 24,
            isFeatured = true,
            listingId = "listing_1",
            createdAt = "2024-01-01T12:00:00Z",
            updatedAt = "2024-01-02T12:00:00Z"
        ),
        Product(
            id = "2",
            name = "Dining Chair",
            description = "Stylish dining chair with wooden legs",
            price = 200.0,
            category = "Chair",
            vendorId = "vendor_1",
            stockQuantity = 5,
            dimensions = Dimensions(45.0, 100.0, 45.0),
            material = "Fabric",
            colorOptions = listOf("#FF0000", "#00FF00", "#0000FF"),
            weight = 10.0,
            assemblyRequired = false,
            productImages = listOf(R.drawable.recliner_chair,R.drawable.recliner_chair),
            warrantyPeriod = 12,
            isFeatured = false,
            listingId = "listing_2",
            createdAt = "2024-01-01T12:00:00Z",
            updatedAt = "2024-01-02T12:00:00Z"
        ),
        Product(
            id = "3",
            name = "Coffee Table",
            description = "Modern coffee table with glass top",
            price = 100.0,
            category = "Table",
            vendorId = "vendor_1",
            stockQuantity = 8,
            dimensions = Dimensions(100.0, 45.0, 60.0),
            material = "Glass",
            colorOptions = listOf("#FF0000", "#00FF00", "#0000FF"),
            weight = 20.0,
            assemblyRequired = true,
            productImages = listOf(R.drawable.recliner_chair),
            warrantyPeriod = 12,
            isFeatured = true,
            listingId = "listing_3",
            createdAt = "2024-01-01T12:00:00Z",
            updatedAt = "2024-01-02T12:00:00Z"
        ),
        Product(
            id = "4",
            name = "Sofa",
            description = "Comfortable 3-seater sofa",
            price = 500.0,
            category = "Sofa",
            vendorId = "vendor_1",
            stockQuantity = 3,
            dimensions = Dimensions(200.0, 80.0, 100.0),
            material = "Fabric",
            colorOptions = listOf("#FF0000", "#00FF00", "#0000FF"),
            weight = 45.0,
            assemblyRequired = false,
            productImages = listOf(R.drawable.recliner_chair),
            warrantyPeriod = 36,
            isFeatured = true,
            listingId = "listing_4",
            createdAt = "2024-01-01T12:00:00Z",
            updatedAt = "2024-01-02T12:00:00Z"
        ),
        Product(
            id = "5",
            name = "Desk",
            description = "Spacious desk with drawers",
            price = 300.0,
            category = "Table",
            vendorId = "vendor_2",
            stockQuantity = 6,
            dimensions = Dimensions(150.0, 75.0, 60.0),
            material = "Wood",
            colorOptions = listOf("#FF0000", "#00FF00", "#0000FF"),
            weight = 30.0,
            assemblyRequired = true,
            productImages = listOf(R.drawable.recliner_chair),
            warrantyPeriod = 24,
            isFeatured = false,
            listingId = "listing_5",
            createdAt = "2024-01-01T12:00:00Z",
            updatedAt = "2024-01-02T12:00:00Z"
        ),
        Product(
            id = "6",
            name = "Dining Chair",
            description = "Stylish dining chair with wooden legs",
            price = 200.0,
            category = "Chair",
            vendorId = "vendor_2",
            stockQuantity = 5,
            dimensions = Dimensions(45.0, 100.0, 45.0),
            material = "Fabric",
            colorOptions = listOf("#FF0000", "#00FF00", "#0000FF"),
            weight = 10.0,
            assemblyRequired = false,
            productImages = listOf(R.drawable.recliner_chair),
            warrantyPeriod = 12,
            isFeatured = false,
            listingId = "listing_2",
            createdAt = "2024-01-01T12:00:00Z",
            updatedAt = "2024-01-02T12:00:00Z"
        ),
        Product(
            id = "7",
            name = "Coffee Table",
            description = "Modern coffee table with glass top",
            price = 100.0,
            category = "Table",
            vendorId = "vendor_2",
            stockQuantity = 8,
            dimensions = Dimensions(100.0, 45.0, 60.0),
            material = "Glass",
            colorOptions = listOf("#FF0000", "#00FF00", "#0000FF"),
            weight = 20.0,
            assemblyRequired = true,
            productImages = listOf(R.drawable.recliner_chair),
            warrantyPeriod = 12,
            isFeatured = true,
            listingId = "listing_3",
            createdAt = "2024-01-01T12:00:00Z",
            updatedAt = "2024-01-02T12:00:00Z"
        ),
        Product(
            id = "8",
            name = "Sofa",
            description = "Comfortable 3-seater sofa",
            price = 500.0,
            category = "Sofa",
            vendorId = "vendor_1",
            stockQuantity = 3,
            dimensions = Dimensions(200.0, 80.0, 100.0),
            material = "Fabric",
            colorOptions = listOf("#FF0000", "#00FF00", "#0000FF"),
            weight = 45.0,
            assemblyRequired = false,
            productImages = listOf(R.drawable.recliner_chair),
            warrantyPeriod = 36,
            isFeatured = true,
            listingId = "listing_4",
            createdAt = "2024-01-01T12:00:00Z",
            updatedAt = "2024-01-02T12:00:00Z"
        ),
        Product(
            id = "9",
            name = "Desk",
            description = "Spacious desk with drawers",
            price = 300.0,
            category = "Table",
            vendorId = "vendor_1",
            stockQuantity = 6,
            dimensions = Dimensions(150.0, 75.0, 60.0),
            material = "Wood",
            colorOptions = listOf("#FF0000", "#00FF00"),
            weight = 30.0,
            assemblyRequired = true,
            productImages = listOf(R.drawable.recliner_chair),
            warrantyPeriod = 24,
            isFeatured = false,
            listingId = "listing_5",
            createdAt = "2024-01-01T12:00:00Z",
            updatedAt = "2024-01-02T12:00:00Z"
        )
    )

    val userList = listOf(
        // Customers
        User(
            id = "user_1",
            firstName = "John",
            lastName = "Doe",
            companyName = null,
            description = null,
            role = UserRoleEnum.CUSTOMER,
            status = UserStatusEnum.ACTIVE
        ),
        User(
            id = "user_2",
            firstName = "Jane",
            lastName = "Smith",
            companyName = null,
            description = null,
            role = UserRoleEnum.CUSTOMER,
            status = UserStatusEnum.PENDING
        ),
        User(
            id = "user_3",
            firstName = "Alice",
            lastName = "Johnson",
            companyName = null,
            description = null,
            role = UserRoleEnum.CUSTOMER,
            status = UserStatusEnum.INACTIVE
        ),

        // Vendors
        User(
            id = "vendor_1",
            firstName = "Bob",
            lastName = "Williams",
            companyName = "Bob's Furniture",
            description = "Supplier of high-quality furniture.",
            role = UserRoleEnum.VENDOR,
            status = UserStatusEnum.ACTIVE
        ),
        User(
            id = "vendor_2",
            firstName = "Carol",
            lastName = "Davis",
            companyName = "Carol's Decor",
            description = "Specializing in modern home decor.",
            role = UserRoleEnum.VENDOR,
            status = UserStatusEnum.PENDING
        ),

        // Admins
        User(
            id = "admin_1",
            firstName = "Dave",
            lastName = "Miller",
            companyName = "Lumashop Admins",
            description = "Administrator of Lumashop platform.",
            role = UserRoleEnum.ADMIN,
            status = UserStatusEnum.ACTIVE
        ),

        // Customer Service Representatives (CSR)
        User(
            id = "csr_1",
            firstName = "Eve",
            lastName = "Brown",
            companyName = "Lumashop Support",
            description = "Customer service representative.",
            role = UserRoleEnum.CSR,
            status = UserStatusEnum.ACTIVE
        ),
        User(
            id = "csr_2",
            firstName = "Frank",
            lastName = "Garcia",
            companyName = "Lumashop Support",
            description = "Handles customer inquiries and issues.",
            role = UserRoleEnum.CSR,
            status = UserStatusEnum.INACTIVE
        )
    )

    val vendorRatingsList = listOf(
        // Rating 1: John Doe rates Jane Smith
        VendorRatings(
            id = "rating_1",
            vendorId = "vendor_1",
            customerId = "user_1",
            rating = 5,
            comment = "Excellent quality and fast delivery!",
            createdAt = getDate(2024, Calendar.JANUARY, 15, 10, 30),
            updatedAt = getDate(2024, Calendar.JANUARY, 15, 10, 30)
        ),

        // Rating 2: Emily Brown rates Jane Smith
        VendorRatings(
            id = "rating_2",
            vendorId = "vendor_1",
            customerId = "user_2",
            rating = 4,
            comment = "Good products, but packaging could be better.",
            createdAt = getDate(2024, Calendar.FEBRUARY, 20, 14, 45),
            updatedAt = getDate(2024, Calendar.FEBRUARY, 20, 14, 45)
        ),

        // Rating 3: John Doe rates Michael Davis
        VendorRatings(
            id = "rating_3",
            vendorId = "vendor_2",
            customerId = "user_1",
            rating = 5,
            comment = "Outstanding customer service and product variety.",
            createdAt = getDate(2024, Calendar.MARCH, 10, 9, 15),
            updatedAt = getDate(2024, Calendar.MARCH, 10, 9, 15)
        ),

        // Rating 4: Emily Brown rates Michael Davis
        VendorRatings(
            id = "rating_4",
            vendorId = "vendor_1",
            customerId = "user_2",
            rating = 3,
            comment = "Average experience, some delays in shipment.",
            createdAt = getDate(2024, Calendar.APRIL, 5, 16, 0),
            updatedAt = getDate(2024, Calendar.APRIL, 5, 16, 0)
        ),

        // Rating 5: Michael Davis rates Jane Smith
        VendorRatings(
            id = "rating_5",
            vendorId = "vendor_2",
            customerId = "user_3", // Note: user_6 is a VENDOR. Typically, customerId should reference a CUSTOMER.
            rating = 4,
            comment = "Satisfied with the purchase.",
            createdAt = getDate(2024, Calendar.MAY, 25, 11, 20),
            updatedAt = getDate(2024, Calendar.MAY, 25, 11, 20)
        )
    )

    private fun getDate(year: Int, month: Int, day: Int, hour: Int, minute: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.time
    }
}
