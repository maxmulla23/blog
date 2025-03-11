import { Textarea } from "@/components/ui/textarea"
import { SearchBar } from "../comp/searchBar"

export default function Page() {
    return (
        <div className="flex items-center bg-gray-100">
            <div className="container relative flex flex-col items-center justify-between px-6 py-8 mx-auto">
            <div className="flex flex-col mt-8">
               <SearchBar />
            </div>
            
            </div>
           
        </div>
       
    )
}

