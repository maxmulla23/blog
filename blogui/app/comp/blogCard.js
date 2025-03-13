import { Card, CardContent, CardFooter, CardHeader, CardTitle } from "@/components/ui/card"


const blogs = [
    {
        id:1,
        title: "This is the title of the blog",
        image: "the image of the blog will be here",
    },
    {
        id:2,
        title: "This is the title of the blog",
        image: "the image of the blog will be here",
    },
    {
        id:3,
        title: "This is the title of the blog",
        image: "the image of the blog will be here",
    },
    {
        id:4,
        title: "This is the title of the blog",
        image: "the image of the blog will be here",
    },
    {
        id:5,
        title: "This is the title of the blog",
        image: "the image of the blog will be here",
    },
    {
        id:6,
        title: "This is the title of the blog",
        image: "the image of the blog will be here",
    }
]

export function BlogCard() {
    return(
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6 p-6">
        {blogs.map((blog) => (
            <Card key={blog.id} className="shadow-lg transition-transform hover:scale-105">
            <CardHeader>
                <CardTitle className="text-lg font-semibold">{blog.title}</CardTitle>
            </CardHeader>
            <hr />
            <CardContent>
                <p>{blog.image}</p>
            </CardContent>
            <hr />
            <CardFooter>
                <p className="text-gray-500">CardFooter</p>
            </CardFooter>
        </Card>
        ))
        }
        </div>
    )
}