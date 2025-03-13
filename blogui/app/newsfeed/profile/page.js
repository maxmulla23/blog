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
                <CardContent className="px-10 pt-10 text-cyan-900">
                <UserCircleIcon className=" h-52 w-auto" />
                </CardContent>
            </Card>
        </div>
        

    )
}