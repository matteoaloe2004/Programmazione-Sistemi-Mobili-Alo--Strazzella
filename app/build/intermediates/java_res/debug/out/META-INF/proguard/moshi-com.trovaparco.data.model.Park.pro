-if class com.trovaparco.data.model.Park
-keepnames class com.trovaparco.data.model.Park
-if class com.trovaparco.data.model.Park
-keep class com.trovaparco.data.model.ParkJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.trovaparco.data.model.Park
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.trovaparco.data.model.Park
-keepclassmembers class com.trovaparco.data.model.Park {
    public synthetic <init>(java.lang.String,java.lang.String,java.lang.String,double,double,java.lang.String,java.util.List,java.util.List,java.lang.String,float,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
