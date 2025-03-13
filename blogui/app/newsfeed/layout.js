
export default function Layout({ children }) {
    return (
        <div className="relative h-screen overflow-auto">
        <header className="z-30 flex items-center w-full h-24 sm:h-32">
            <div className="container flex items-center justify-between px-6 mx-auto">
              <h2 className="font-bold text-gray-900 uppercase text-2xl">EchoBlog</h2>
                <div className="flex items-center">
                     <nav className="items-center hidden text-lg text-gray-800 uppercase font-sen dark:text-white lg:flex">
                    <a href="/newsfeed" className="flex px-6 py-2 text-cyan-500 border-b-2 border-cyan-500">
                        Home
                    </a>
                    <a href="#" className="flex px-6 py-2 hover:text-cyan-500">
                        Genres
                    </a>
                    <a href="/newsfeed/profile" className="flex px-6 py-2 hover:text-cyan-500">
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
        <div className="relative z-20">{children}</div>
        </div>
    )
}