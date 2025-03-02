"use client"
import Image from "next/image"
import { UserCircleIcon } from '@heroicons/react/24/solid'
import { useState } from "react"

export default function Page() {
    const [passwordShown, setPasswordShown] = useState(false)
    const togglePasswordVisibility = () => setPasswordShown((cur) => !cur)
    return(
        <div className="min-h-screen flex ">
        <div className="w-1/2 relative">
          <Image
            src="/login.jpg"
            alt="Login Background"
            layout="fill"
            objectFit="cover"
            className="absolute inset-0"
          />
          <div className="absolute inset-0 bg-black opacity-50"></div>
        </div>
        <div className="w-1/2 flex items-center justify-center p-12 bg-gray-200">
        <div className="w-full max-w-md space-y-8 px-4 py-6 bg-white rounded-md shadow-sm">
    <UserCircleIcon className="mx-auto h-12 w-auto text-cyan-900" />
    <h2 className="mt-4 text-center text-5xl font-serif tracking-tight text-cyan-900">
        EchoBlog
    </h2>
      <div className='flex justify-center items-center'>
      <div className="w-full max-w-xs">
      <form className="mx-auto max-w-md text-left">
          <div className="mb-6">
            <label htmlFor="email" className="block font-medium text-gray-900 mb-2">
              Your Username
            </label>
            <input
              id="username"
              type="text"
              name="username"
              placeholder="jsmith"
              className="w-full p-3 border border-gray-300 rounded-lg focus:border-cyan-500"
            />
          </div>
          <div className="mb-6 relative">
            <label htmlFor="password" className="block font-medium text-gray-900 mb-2">
              Password
            </label>
            <input
              id="password"
              type={passwordShown ? "text" : "password"}
              placeholder="********"
              className="w-full p-3 border border-gray-300 rounded-lg focus:border-blue-500"
            />
            <button
              type="button"
              onClick={togglePasswordVisibility}
              className="absolute right-3 top-10 text-gray-500 hover:text-gray-700"
            >
              {passwordShown ? "🙈" : "👁️"}
            </button>
          </div>
          <button className="bg-cyan-900 hover:bg-gray-800 text-white w-full py-3 rounded-lg mt-6">
            Sign In
          </button>
          <div className="flex justify-end mt-4">
            <a href="#" className="text-gray-700 font-medium">
              Forgot password
            </a>
          </div>
          <hr className="mt-4 border-gray-700"/>
          <button
            type="button"
            className="border border-gray-300 w-full py-3 mt-6 text-black rounded-lg flex items-center justify-center gap-2"
          >
            <Image
              src="/googlelogo.png"
              alt="Google Logo"
              width={24}
              height={24}
              className="h-6 w-6"
            />
            Sign in with Google
          </button>
          <p className="text-center text-gray-600 mt-4">
            Not registered?{" "}
            <a href="/signup" className="text-cyan-900 font-medium">
              Create account
            </a>
          </p>
        </form>
  </div>
  </div>
  </div>
        </div>
      </div>
    )
}