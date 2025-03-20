"use client";
import { useState } from "react";
import { usePathname } from "next/navigation";

export default function Layout({ children }) {
    const [isMenuOpen, setIsMenuOpen] = useState(false);
    const pathname = usePathname(); // Get current route

    const navLinks = [
        { name: "Home", href: "/newsfeed" },
        { name: "Genres", href: "/newsfeed/genres" },
        { name: "Profile", href: "/newsfeed/profile" },
    ];

    return (
        <div className="relative h-screen overflow-auto">
            {/* Header */}
            <header className="z-30 flex items-center w-full h-24 sm:h-32 bg-white dark:bg-gray-900 shadow-md">
                <div className="container flex items-center justify-between px-6 mx-auto">
                    <h2 className="font-bold text-gray-900 dark:text-white uppercase text-2xl">EchoBlog</h2>

                    {/* Desktop Navigation */}
                    <nav className="hidden lg:flex items-center text-lg text-gray-800 dark:text-white uppercase font-sen">
                        {navLinks.map((link) => (
                            <a
                                key={link.href}
                                href={link.href}
                                className={`px-6 py-2 transition-all ${
                                    pathname === link.href 
                                        ? "text-cyan-500 border-b-2 border-cyan-500" 
                                        : "hover:text-cyan-500"
                                }`}
                            >
                                {link.name}
                            </a>
                        ))}
                    </nav>

                    {/* Mobile Menu Button */}
                    <button 
                        className="lg:hidden flex flex-col ml-4" 
                        aria-label="Toggle navigation menu"
                        onClick={() => setIsMenuOpen(!isMenuOpen)}
                    >
                        <span className="w-6 h-1 mb-1 bg-gray-800 dark:bg-white transition-all"></span>
                        <span className="w-6 h-1 mb-1 bg-gray-800 dark:bg-white transition-all"></span>
                        <span className="w-6 h-1 bg-gray-800 dark:bg-white transition-all"></span>
                    </button>
                </div>
            </header>

            {/* Mobile Navigation */}
            {isMenuOpen && (
                <nav className="lg:hidden absolute top-24 left-0 w-full bg-white dark:bg-gray-900 shadow-md p-6 flex flex-col text-center text-lg uppercase">
                    {navLinks.map((link) => (
                        <a
                            key={link.href}
                            href={link.href}
                            className={`py-2 transition-all ${
                                pathname === link.href
                                    ? "text-cyan-500 border-b border-cyan-500" 
                                    : "hover:text-cyan-500"
                            }`}
                        >
                            {link.name}
                        </a>
                    ))}
                </nav>
            )}

            {/* Page Content */}
            <div className="relative z-20 p-6">{children}</div>
        </div>
    );
}
