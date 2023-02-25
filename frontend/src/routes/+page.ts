import { error } from '@sveltejs/kit';
import type { PageLoad } from './$types';

export const load = (async ({ params }) => {

    const res = await fetch('http://localhost:8080/courses');
    const fetchedData = await res.json();
    console.log({
        courses: fetchedData
    })
    return {
        courses: fetchedData
    };
}) satisfies PageLoad;