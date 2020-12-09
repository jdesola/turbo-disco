<template>
  <data-search
        componentId="SearchSensor"
        queryFormat="or"
        :dataField="['name', 'age', 'color', 'hairLength', 'priorExperienceMonths', 'previousJobs', 'skills', 'description']"
    />
</template>

<script>
export default {
    name: "SearchBar",

}
</script>

<style>

</style>