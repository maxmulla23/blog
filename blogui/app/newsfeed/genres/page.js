import GenreCard from "@/app/comp/genreCard";
import { Card, CardContent } from "@/components/ui/card";

export default function Page() {
    return (
        <div> 
            <Card className="h-auto w-screen mt-0">
                <CardContent>
                    <GenreCard />
                </CardContent>
            </Card>
        </div>
    )
}