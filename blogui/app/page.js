import Image from "next/image";

export default function Home() {
  return (
    
       <main className="relative h-screen overflow-auto bg-white dark:bg-gray-100">
    <header className="z-30 flex items-center w-full h-24 sm:h-32">
        <div className="container flex items-center justify-between px-6 mx-auto">
          <h2 className="font-bold text-gray-900 mt-4 uppercase text-2xl">EchoBlog</h2>
            <div className="flex items-center">
            
            </div>
        </div>
    </header>
    <div className="relative z-20 flex items-center bg-gray-200 dark:bg-gray-200">
        <div className="container relative flex flex-col items-center justify-between px-6 py-8 mx-auto">
            <div className="flex flex-col mt-8">
                <h1 className="w-full text-4xl text-center text-blue-900 uppercase sm:text-5xl">
                    Where your voice echoes across the internet
                </h1>
                <h2 className="w-full max-w-2xl py-8 mx-auto text-xl font-light text-center text-gray-800">
                  Lorem ipsum dolor sit amet consectetur adipisicing elit.
                  Reprehenderit inventore rerum ut sunt adipisci labore. Facere
                  magni laudantium delectus quasi illum repellat neque laboriosam,
                </h2>
                <div className="flex items-center justify-center mt-4">
                    <button type="button" className="px-4 py-2 mr-4 text-white uppercase bg-cyan-900 rounded-lg border-2 border-transparent text-md hover:bg-gray-900">
                        Get started
                    </button>
                    
                    
                    <button type="button" className="px-4 py-2 text-gray-800 uppercase bg-transparent border-2 rounded-lg border-gray-800 hover:bg-gray-800 hover:text-white text-md">
                        Login
                    </button>
                    
                </div>
            </div>
            <div className="flex justify-center items-center relative w-full mx-auto mt-6 md:mt-0">
                      <Image
          
          src="/blog.png"
          alt="app logo"
          width={400}
          height={100}
          priority
        />
                {/* <img src={home} alt="journal pic" className='w-96 h-96' /> */}
            </div>
        </div>
    </div>
</main>
  );
}
