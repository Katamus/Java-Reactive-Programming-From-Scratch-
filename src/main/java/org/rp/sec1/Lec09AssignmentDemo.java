package org.rp.sec1;

import org.rp.courseutil.Util;
import org.rp.sec1.assignment.FileService;

public class Lec09AssignmentDemo {

    public static void main(String[] args) {

        FileService.read("file03.txt")
                .subscribe(Util.onNext());

        FileService.write("file03.txt","This is file 3")
                .subscribe(Util.onNext());

        FileService.delete("file03.txt")
                .subscribe(Util.onNext());

    }
}
