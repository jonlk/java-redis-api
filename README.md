## Java Redis Demo Api
### Java 17, Spring Boot, Redis Cache and Docker

---

**You will need to install Redis locally or launch in Docker Desktop (preferred)**

Docker Instructions: `docker run -d --name myrediscache -p 6379:6379 redis:latest`

From Postman or similar

- Setting a cache item
- POST 
- `http://localhost:8080/api/cache/setCacheItem`

Cache Item Body Example:
```
{
    "value": "Setting a new cache item"
}
```
**Example Response:**
```
{
    "id": "4f034b58-82cd-4121-87a8-e5326400e964",
    "value": "Setting a new cache item",
    "createdDate": "2021-12-16T00:25:59.233+00:00"
}
```

- To get a cache item, pass in the ID from the response
- GET
- `http://localhost:8080/api/cache/getCacheItem/4f034b58-82cd-4121-87a8-e5326400e964`

