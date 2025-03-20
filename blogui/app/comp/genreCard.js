import { Card, CardHeader, CardTitle } from "@/components/ui/card"

const genre = [
    {
        id: 1,
        name: "horror",
    },
    {
        id: 2,
        name: "software",
    },
    {
        id: 3,
        name: "drama",
    },
    {
        id: 4,
        name: "sci-fi",
    },
    {
        id: 5,
        name: "action",
    },
    {
        id: 6,
        name: "educational",
    },
]

export default function GenreCard() {
    return(
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6 p-6">
        {genre.map((genre) => (
            <Card key={genre.id} className="shadow-lg transition-transform hover:scale-105">
            <CardHeader>
                <CardTitle className="text-lg uppercase font-semibold">{genre.name}</CardTitle>
            </CardHeader>
        </Card>
        ))
        }
        </div>
    )
}