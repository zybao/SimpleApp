package com.oab.simpleapp.widget;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by bao on 2017/7/9.
 */
@AutoValue
public abstract class Bean implements Parcelable {
    abstract String name();
    abstract Integer age();

    public static Bean create(String name, Integer age) {
        return builder()
                .name(name)
                .age(age)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_Bean.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder age(Integer age);

        public abstract Bean build();
    }
}
