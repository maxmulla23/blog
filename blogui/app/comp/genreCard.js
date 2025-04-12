"use client"
import { Card, CardHeader, CardTitle } from "@/components/ui/card"
import axios from "axios";
import { useEffect, useState } from "react"
import { toast } from "react-toastify";



export default function GenreCard() {
    const [genres, setGenres] = useState([]);

    useEffect(() => {
        const getGenres = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/genre");
                console.log(response.data);
                setGenres(response.data);
            } catch (error) {
                console.log("Error fetching genres:", error);
            }
        };
        getGenres();
    }, []);
    

    return(
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6 p-6">
        {genres.map((genre) => (
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