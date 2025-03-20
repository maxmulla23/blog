import { BlogCard } from "@/app/comp/blogCard";
import { Card, CardContent } from "@/components/ui/card";
import { UserCircleIcon } from '@heroicons/react/24/solid'

const User = {
    name: "Maxwell Mulla",
    email: "maxmulla23@gmail.com",

}

export default function Page() {
    return(
        <div className="flex justify-center">
            <Card className="h-auto w-screen shadow-lg mt-0">
            
                <CardContent className="text-cyan-900">
                <UserCircleIcon className=" h-52 w-auto" />
                <div className="flex flex-col ml-2">
                <h1 className="uppercase text-4xl">{User.name}</h1>
                <h2 className="text-lg">{User.email}</h2>
                </div>
                <hr className="mt-6 border-gray-800 " />
                <div className="flex items-center justify-center mt-5">
                    <BlogCard />
                </div>
               
                
                </CardContent>
                
            </Card>
        </div>
        

    )
}