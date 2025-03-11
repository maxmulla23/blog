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
        <div>
        {blogs.map((blog) => (
            <Card key={blog.id}>
            <CardHeader>
                <CardTitle>{blog.title}</CardTitle>
            </CardHeader>
            <hr />
            <CardContent>
                <p>{blog.image}</p>
            </CardContent>
            <hr />
            <CardFooter>
                <p>CardFooter</p>
            </CardFooter>
        </Card>
        ))
        }
        </div>
    )
}