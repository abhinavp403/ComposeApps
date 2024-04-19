package dev.abhinav.composeapps.jetnews

internal fun <E> MutableSet<E>.addOrRemove(element: E) {
    if (!add(element)) {
        remove(element)
    }
}
