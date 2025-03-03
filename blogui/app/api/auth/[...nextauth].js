import axios from "axios";
import NextAuth from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";

export default NextAuth({
    providers: [
        CredentialsProvider({
            name: 'Credentials',
    
            credentials: {
                username: { label: "Username", type: "text"},
                password: { label: "Password", type: "password" }
            },
            async authorize(credentials, req) {
    
                const res = await axios("http://localhost:8080/api/auth/login", {
                    method: 'POST',
                    body: JSON.stringify(credentials),
                    headers: { "Content-Type": "application/json" }
                })
                const user = await res.json()
    
                if (res.ok && user) {
                    return user
                }
    
                return null
            }
        })
    ],
    callbacks: {
        async jwt({ token, user }) {
            if (user) {
                token.id = user.id;
                token.username = user.username;
            }
            return token;
        },
        async session({ session, token }) {
            session.user.id = token.id;
            session.user.username = token.username;
            return session;
        },
    },
    pages: {
        signIn: "/login",
    },
    secret: process.env.NEXTAUTH_SECRET,
})
