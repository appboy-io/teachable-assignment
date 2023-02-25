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
  <div class="container">
    <p class="fs-1 fw-bold">{data.course.name}</p>
    <p class="fs-4 fst-italic">{data.course.heading}</p>
  </div>
  <div class="container-md">
    <p class="fs-3 fw-bold">Enrolled Students</p>
    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">Student Name</th>
          <th scope="col">Student Email</th>
        </tr>
      </thead>
      <tbody>
        {#each data.enrollments as enrolled}
        <tr>
          <td>{enrolled.name}</td>
          <td>{enrolled.email}</td>
        </tr>
        {/each}
      </tbody>
    </table>
  </div>
</div>