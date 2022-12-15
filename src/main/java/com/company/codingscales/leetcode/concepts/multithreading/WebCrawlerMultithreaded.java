package com.company.codingscales.leetcode.concepts.multithreading;


import java.util.*;
import java.util.concurrent.*;

public class WebCrawlerMultithreaded {
    interface HtmlParser {
        public default List<String> getUrls(String url) {
            return null;
        }
    }

    /**
     * How does Multithreading work for Webcrawler
     *
     * We have a thread pool which will fetch the new URLs
     * To Iterate over all the urls, thread pool fetches, we need a queue - We use BlockingQueue so that, no 2 threads can effect the state
     * Other way is, when ever we are polling from the queue - ReentrantLock - lock.lock() and lock.unlock() -> All threads should be bounded on this lock
     */
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4); //  Number of workers - 4

        HashSet<String> seen = new HashSet<>(); // static volatile ?
        LinkedBlockingQueue<Future> taskQueue = new LinkedBlockingQueue<>();  // Workers which call the API.  Get A worker from  threadPool and add it to queue

        ArrayDeque<String> queue = new ArrayDeque<>(); // When worker fetches URL's populate the queue.
        ArrayList<String> res = new ArrayList<>();

        String domain = getDomain(startUrl);
        queue.offer(startUrl);

        while (true) {
            if (queue.isEmpty()) {
                if (taskQueue.isEmpty()) {
                    try {
                        threadPool.shutdown();
                    } catch(Exception ex) {
                        System.out.println(ex.getStackTrace());
                    }
                    break;
                } else {
                    try {
                        Future task = taskQueue.poll();
                        task.get();
                    } catch(Exception ex) {
                        System.out.println(ex.getStackTrace());
                    }
                }
            } else {
                String url = queue.pollFirst();

                // if one thread already explored this, don't re-add it.
                if (seen.contains(url) || differentDomain(domain, url))
                    continue;

                res.add(url);
                seen.add(url);

                taskQueue.offer(threadPool.submit(() -> {
                    List<String> nei = htmlParser.getUrls(url); // want to do this in thread
                    for (String each :  nei) {
                        if (seen.contains(each) || differentDomain(domain, each)) {
                            continue;
                        }

                        // add all possibilities to queue to process
                        queue.offer(each);
                    }
                }));
            }
        }

        return res;
    }

    private boolean differentDomain(String domain, String url)  {
        return !getDomain(url).equals(domain);
    }

    private String getDomain(String url) {
        String[] paths = url.split("//");
        return paths[1].split("/")[0];
    }

    public static void main(String[] args) {

    }
}
