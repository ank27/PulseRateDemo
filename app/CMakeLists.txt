cmake_minimum_required(VERSION 3.4.1)

#add_library( # Sets the name of the library.
#             native-lib
#
#             # Sets the library as a shared library.
#             SHARED
#
#             # Provides a relative path to your source file(s).
#             src/main/cpp/native-lib.cpp)

add_library(pt_chambino_p_pulse_Pulse SHARED src/main/cpp/pt_chambino_p_pulse_Pulse.cpp)
add_library(pt_chambino_p_pulse_Pulse_Face SHARED src/main/cpp/pt_chambino_p_pulse_Pulse_Face.cpp)
add_library(Pulse SHARED src/main/cpp/Pulse.cpp)
add_library(Profiler SHARED src/main/cpp/profiler/Profiler.cpp)

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

#include_directories(src/main/jniLibs/jni)
#add_library( lib-opencv SHARED IMPORTED )
#target_link_libraries(${OpenCV_LIBS} )

set(OpenCV_DIR "src/main/jniLibs/jni")
FIND_PACKAGE(OpenCV REQUIRED)
message(STATUS "OpenCV libraries: ${OpenCV_LIBS}")

target_link_libraries(Pulse ${OpenCV_LIBS} ${log-lib} )

target_link_libraries(Profiler ${OpenCV_LIBS} ${log-lib} )

target_link_libraries(Profiler Pulse)
target_link_libraries(pt_chambino_p_pulse_Pulse ${OpenCV_LIBS})
target_link_libraries(pt_chambino_p_pulse_Pulse Pulse)
target_link_libraries(Pulse EvmGdownIIR)
target_link_libraries(pt_chambino_p_pulse_Pulse_Face ${OpenCV_LIBS})