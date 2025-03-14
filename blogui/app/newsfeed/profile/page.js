import { Card, CardContent } from "@/components/ui/card";
import { UserCircleIcon } from '@heroicons/react/24/solid'

const User = {
    name: "Maxwell Mulla",
    email: "maxmulla23@gmail.com",

}

export default function Page() {
    return(
        <div>
            <Card className="h-auto w-screen mt-0">
            <div className="flex flex-col gap-3">
                <CardContent className="text-cyan-900">
                <UserCircleIcon className=" h-52 w-auto" />
                <div >
                <h1 className="uppercase text-4xl">{User.name}</h1>
                <h2 className="text-lg">{User.email}</h2>
                </div>
               
                
                </CardContent>
                </div>
            </Card>
        </div>
        

    )
}