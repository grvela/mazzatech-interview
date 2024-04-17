# Mazzatech Interview

## AZShip challenge
## Running project

With docker:

```bash
  docker compose up 
```

## Features

- [x]  Create a Shipping
- [x]  Get a Shipping by ID
- [x]  Update a Shipping by ID
- [x]  Delete a Shipping by ID
- [x]  Search for Shipping with query param



## AZShip API

## Create a Shipping

```http
POST /shipping
```

Creates a new shipping record.

### Request Body

```json
{
  "clientId": "client_id",
  "properties": [
    {
      "name": "weight",
      "value": "12kg"
    },
    {
      "name": "height",
      "value": "10m"
    }
  ]
}
```

| Parameter  | Type     | Description             |
| :--------- | :------- | :---------------------- |
| `clientId` | `string` | **Required**. Client ID |
| `properties` | `array` | Additional properties for the shipping |
| `name`       | `string` | Property name           |
| `value`      | `string` | Property value          |

### Response

A successful request returns the created shipping object.

---

## Retrieve Shipping Information

```http
GET /shipping/:id
```

Retrieves information about a specific shipping using its ID.

### Path Parameters

| Parameter | Type     | Description               |
| :-------- | :------- | :------------------------ |
| `id`      | `string` | **Required**. Shipping ID |

### Response

A successful request returns the shipping information.

---

## Update Shipping

```http
PUT /shipping/:id
```

Updates information about a specific shipping using its ID.

### Path Parameters

| Parameter | Type     | Description               |
| :-------- | :------- | :------------------------ |
| `id`      | `string` | **Required**. Shipping ID |

### Request Body

```json
{
  "properties": [
    {
      "name": "type",
      "value": "delivery"
    }
  ]
}
```

### Response

A successful request returns the updated shipping information.

---

## Delete Shipping

```http
DELETE /shipping/:id
```

Deletes a specific shipping using its ID.

### Path Parameters

| Parameter | Type     | Description               |
| :-------- | :------- | :------------------------ |
| `id`      | `string` | **Required**. Shipping ID |

### Response

A successful request returns a success message.

---

## Find Shipping by Query

```http
GET /shipping?query=weight&value=12m
```

Finds shipping information based on a query parameter.

### Query Parameters

| Parameter | Type     | Description                   |
| :-------- | :------- | :---------------------------- |
| `query`   | `string` | **Required**. Query parameter |
| `value`   | `string` | **Optional**. Query value     |
| `page`    | `string` | **Optional**. Query page     |
| `size`    | `string` | **Optional**. Query size     |

### Response

A successful request returns the matching shipping information.

---

This project was developed in a microservices context, where the client ID is mandatory. It follows the principle of YAGNI (You Ain't Gonna Need It) as there are few business rules.

The microservice architecture ensures scalability and flexibility by breaking down the application into smaller, independent services. In this project, passing the client ID is mandatory for security and tracking purposes.

The YAGNI principle advocates for implementing only what is necessary at the moment, avoiding unnecessary features that might not be needed in the future. Since there are only a few business rules in this project, adhering to this principle helps keep the codebase lean and maintainable.

NOTE: Using a hexagonal architecture for a CRUD operation, which involves simple Create, Read, Update, and Delete actions, can be considered overengineering. Hexagonal architecture is typically used for complex systems where the business logic is intricate and there are multiple layers of abstraction. For a straightforward CRUD functionality, a simpler architecture might suffice, reducing unnecessary complexity.