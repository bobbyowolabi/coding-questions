package com.owodigi.merge.intervals;

import java.util.*;

/**
 * Completed
 */

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

// Sort the jobs
// Iterate through the jobs
// keep track of the maximum individual load while traversing
// For each job, calculate the load for every job it intersects with and store it
class MaximumCPULoad {

    // [a]{b}
    // [a  {b}  ]
    // [a  {b]  }
    // taking advantage of sorting
    private static boolean overlap(final Job a, final Job b) {
        return a.start <= b.start && b.start <= a.end;
    }

    public static int findMaxCPULoad(final List<Job> jobs) {
        if (jobs == null || jobs.size() < 2) {
            return 0;
        }
        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
        int maxIndividualLoad = 0;
        int maxCombinedLoad = 0;
        for (int i = 0; i < jobs.size(); ++i) {
            final Job currentJob = jobs.get(i);
            maxIndividualLoad = Math.max(maxIndividualLoad, currentJob.cpuLoad);
            int j = i + 1;
            int load = currentJob.cpuLoad;
            while (j < jobs.size()) {
                final Job nextJob = jobs.get(j);
                if (overlap(currentJob, nextJob)) {
                    load += nextJob.cpuLoad;
                    ++j;
                } else {
                    break;
                }
            }
            maxCombinedLoad = Math.max(maxCombinedLoad, load);
        }
        return Math.max(maxIndividualLoad, maxCombinedLoad);
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
