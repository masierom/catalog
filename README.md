# Project component: catalog (shop-catalog)
Component of Cloud Project (UfPrCloud2);

Composed of:
- catalog (shop-catalog)
- purchase (shop-purchase)
- shop-rating
- shop-recommender
- registry
- gateway

## Mini API docs
**Get product list**
```
GET /api/products
```
- **Return** an array of all Products (JSON object) 

**Get product info by id**
```
GET /api/products/{id}
```
- Path Parameters: id (productId)
- **Return** Product (JSON object) 

**Insert new product**
```
POST /api/products
```
- Body Parameters: title, description, category, price, availability
- **Return** Product (JSON object) 

**Update availability of a single product**
```
PUT /api/products/{id}/availability/{val}
```
- Path Parameters: id (productId), val (amount)
- **Return** Product (JSON object) 
