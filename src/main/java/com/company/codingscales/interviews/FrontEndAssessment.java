package com.company.codingscales.interviews;

import java.util.*;

public class FrontEndAssessment {
    static class Tuple {
        String title; // movie name
        List<String> actors;
        Tuple(String title, List<String> actors) {
            this.title = title;
            this.actors = actors;
        }
    }

    HashMap<String, Set<String>> movieToActors = new HashMap();
    HashMap<String, Set<String>> actorToMovie = new HashMap<>();

    void solve(List<Tuple> input) {
        for(Tuple t : input) {
            movieToActors.putIfAbsent(t.title, new HashSet<>());
            movieToActors.get(t.title).addAll(t.actors);

            for(String actor: t.actors) {
                actorToMovie.putIfAbsent(actor, new HashSet<>());
                actorToMovie.get(actor).add(t.title);
            }
        }
    }

    int getIndegree(String a1, String a2) {
        if (a1.equals(a2))
            return 0;

        ArrayDeque<String> dq = new ArrayDeque<>(); // dq of movies;
        for(String movie: actorToMovie.getOrDefault(a1, new HashSet<>())) {
            dq.offer(movie);
        }

        HashSet<String> visitedMovies = new HashSet<>();
        HashSet<String> visitedActors = new HashSet<>();

        int indegree = 1;

        visitedActors.add(a1);

        while (!dq.isEmpty()) {
            int n = dq.size();

            for(int i = 0; i < n; i++) {
                String movie = dq.pollFirst();

                if (visitedMovies.contains(movie)) {
                    continue;
                }

                visitedMovies.add(movie);
                Set<String> neiActors = movieToActors.getOrDefault(movie, new HashSet<>());
                if (neiActors.contains(a2)) {
                    return indegree;
                }

                for(String otherActor : neiActors) {
                    if (visitedActors.contains(otherActor)) {
                        continue;
                    }
                    visitedActors.add(otherActor);
                    Set<String> otherMoviesForThisActor = actorToMovie.getOrDefault(otherActor, new HashSet<>());
                    for(String each : otherMoviesForThisActor) {
                        dq.offerLast(each);
                    }
                }
            }

            indegree++;
        }

        return -1;
    }
}
