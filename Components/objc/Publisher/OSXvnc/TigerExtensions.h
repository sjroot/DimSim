//
//  TigerExtensions.h
//  OSXvnc
//
//  Created by Jonathan Gillaspie on Fri Jul 11 2003.
//  Copyright (c) 2003 RedstoneSoftware. All rights reserved.
//


#import <Foundation/Foundation.h>
#import <Carbon/Carbon.h>

#import "RFBBundleProtocol.h"

@interface TigerExtensions : NSObject <RFBBundleProtocol> {
}

+ (void) systemServerShouldQuit: (NSNotification *) aNotification;
+ (void) systemServerShouldContinue: (NSNotification *) aNotification;

+ (void) loadKeyboard: (KeyboardLayoutRef) keyboardLayoutRef;
+ (void) loadUnicodeKeyboard;
	
@end
