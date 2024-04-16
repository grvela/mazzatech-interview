db.createUser(
        {
            user: "mazzatech",
            pwd: "password",
            roles: [
                {
                    role: "readWrite",
                    db: "database"
                }
            ]
        }
);