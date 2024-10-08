# LumaShop - E-commerce Furniture Store

**LumaShop** is an Android e-commerce application designed for selling furniture. It allows users to browse through various furniture items, search for products, add them to the cart, and proceed to checkout. It also includes features for order tracking, rating vendors, and viewing past orders.

## Features

- **Product Browsing**: Browse a catalog of furniture products displayed in categories.
- **Product Details**: View detailed descriptions, prices, and vendors for each product.
- **Search Functionality**: Search for furniture based on product names.
- **Shopping Cart**: Add products to a cart and proceed to checkout.
- **Order Management**: Track order status and view past orders.
- **Vendor Reviews**: Rate and review vendors for each purchase.
- **User-Friendly Navigation**: Simple and intuitive navigation between fragments like Home, Search, Cart, Profile, and Orders.
- **Secure Checkout**: A smooth checkout experience with an order status update to track your purchases.
- **Modern UI**: A sleek and minimalistic design inspired by the latest mobile UI trends, integrated with a custom color palette for a polished look.

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/Ravishka2000/LumaShop-Android.git
    ```

2. Open the project in **Android Studio**.
3. Build the project and install it on your device or emulator.

## Tech Stack

- **Language**: Kotlin
- **Minimum SDK**: Android 12 (API 31)
- **Backend**: .NET with MongoDB (for managing orders and inventory)
- **UI**: Using ViewBinding for fragment and activity management
- **RecyclerView**: For displaying product listings, cart items, and orders.
- **Architecture**: MVVM pattern
- 
## Key Components

- **Fragments**:
    - `HomeFragment`: Displays products and allows users to view product details.
    - `SearchFragment`: Provides a search bar to find products by name.
    - `CartFragment`: Displays selected items with a checkout button.
    - `ProfileFragment`: User profile management.
    - `AllOrdersFragment`: Shows past orders and allows users to track them.
    - `TrackOrdersFragment`: Displays order details and current status.
    - `VendorDetailsFragment`: Shows vendor information, allowing ratings and reviews.

## License

This project is licensed under the MIT License.
