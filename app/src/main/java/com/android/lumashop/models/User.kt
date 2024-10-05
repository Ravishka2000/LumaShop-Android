package com.android.lumashop.models

data class User(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val companyName: String? = null,
    val description: String? = null,
    val role: UserRoleEnum = UserRoleEnum.CUSTOMER,
    val status: UserStatusEnum = UserStatusEnum.PENDING,
)

enum class UserStatusEnum(val value: Int)
{
    ACTIVE(1),
    INACTIVE(2),
    PENDING(3)
}

enum class UserRoleEnum(val value: Int) {
    CUSTOMER(1),
    VENDOR(2),
    ADMIN(3),
    CSR(4)
}