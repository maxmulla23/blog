import { useEffect } from 'react';
import { useRouter } from 'next/router';
import { toast } from 'react-toastify';

export default function Logout() {
    const router = useRouter();

    useEffect(() => {
        localStorage.removeItem('token');
        localStorage.removeItem('username');

        toast.done("user is logged out");
        
        router.push('/login');
    }, [router]);

    return null;
}