<!-- src/routes/index.svelte -->
<script lang="ts">

  import type { PageData } from "./$types";

  export let data: PageData;
</script>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="d-flex justify-content-center container-fluid">
    <a class="navbar-brand" href="/"><p class="fs-1 fw-bold">TEACHABLE COURSES</p></a>
  </div>
</nav>
<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th scope="col">Course Name</th>
        <th scope="col">Course Heading</th>
        <th scope="col">Published</th>
      </tr>
    </thead>
    <tbody>
      {#each data.courses as course}
      {#if course.is_published }
      <tr>
        <td><a href="/courses/{course.id}">{course.name}</a></td>
        <td>{course.heading}</td>
        <td>{course.is_published}</td>
      </tr>
      {/if}
      {/each}
    </tbody>
  </table>
</div>