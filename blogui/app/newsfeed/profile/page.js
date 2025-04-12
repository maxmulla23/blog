"use client"
import { BlogCard } from "@/app/comp/blogCard";
import { NewBlog } from "@/app/comp/newblog";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { UserCircleIcon } from '@heroicons/react/24/solid'
import axios from "axios";
import { jwtDecode } from "jwt-decode";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";

const User = {
    name: "Maxwell Mulla",
    email: "maxmulla23@gmail.com",

}

export default function Page() {
    const [userInfo, setUserInfo] = useState(null)

    useEffect(() => {
        const getUserInfo = async () => {
            try {
                const token = localStorage.getItem('token')

                if (!token) {
                    toast.error("No token found");
                    return;
                }
    
                const decodedToken = jwtDecode(token)
                const username = decodedToken.sub || decodedToken.username
    
                if (!username) {
                    toast.error("Username not found in token");
                    return;
                }
    
                const response = await axios.get(`http://localhost:8080/api/userinfo/get/${username}`, {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                })
                setUserInfo(response.data);
                console.log(response.data);
            } catch (error) {
                console.log(error);
                toast.error("failed to fetch!")
            }
        }
            getUserInfo();
    }, []);
    return(
        <div className="flex justify-center">
            <Card className="h-auto w-screen shadow-lg mt-0">
            
                <CardContent className="text-cyan-900">
                    {userInfo ? (
                        <>
                            <UserCircleIcon className=" h-52 w-auto" />
                            <div className="flex flex-col ml-2">
                            <h1 className="uppercase text-4xl">{userInfo.firstName}</h1>
                            <h2 className="text-lg">{userInfo.email}</h2>
                            </div>
                            <div className="flex items-end justify-end">
                            <NewBlog />
                            </div>
                            <hr className="mt-6 border-gray-800 " />
                            <div className="flex items-center justify-center mt-5">
                            <BlogCard />
                            </div>
                        </>
                    ) : (
                        <p className="text-center text-gray-500">Loading user info...</p>
                    )}
                
               
                
                </CardContent>
                
            </Card>
        </div>
        

    )
}