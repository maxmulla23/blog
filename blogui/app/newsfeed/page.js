import { Textarea } from "@/components/ui/textarea"

export default function Page() {
    return (
        <main className="relative h-screen overflow-auto bg-white dark:bg-gray-100">
        <header className="z-30 flex items-center w-full h-24 sm:h-32">
            <div className="container flex items-center justify-between px-6 mx-auto">
              <h2 className="font-bold text-gray-900 uppercase text-2xl">EchoBlog</h2>
                <div className="flex items-center">
                     <nav className="items-center hidden text-lg text-gray-800 uppercase font-sen dark:text-white lg:flex">
                    <a href="#" className="flex px-6 py-2 text-indigo-500 border-b-2 border-indigo-500">
                        Home
                    </a>
                    <a href="#" className="flex px-6 py-2 hover:text-indigo-500">
                        Genres
                    </a>
                    <a href="#" className="flex px-6 py-2 hover:text-indigo-500">
                        Profile
                    </a>
                </nav>
                <button className="flex flex-col ml-4 lg:hidden">
                    <span className="w-6 h-1 mb-1 bg-gray-800 dark:bg-white">
                    </span>
                    <span className="w-6 h-1 mb-1 bg-gray-800 dark:bg-white">
                    </span>
                    <span className="w-6 h-1 mb-1 bg-gray-800 dark:bg-white">
                    </span>
                </button>
                </div>
            </div>
        </header>
        </main>
    )
}

