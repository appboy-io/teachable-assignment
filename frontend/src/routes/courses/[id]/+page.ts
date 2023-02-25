import { error } from '@sveltejs/kit';
import type { PageLoad } from './$types';

/** @type {import('./$types').PageLoad} */
export const load = (async ({ params }) => {
    const { id } = params;
    const res = await fetch(`http://localhost:8080/courses/${id}`);
    const fetchedData = await res.json();
    return {
        course: fetchedData.course,
        enrollments: fetchedData.enrollments
    };
}) satisfies PageLoad;